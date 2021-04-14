package com.sunil.leetcode.dd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * We are given a list schedule of employees, which represents the working time for each employee.
 * Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
 * Return the list of finite intervals representing common, positive-length free time for all employees,
 * also in sorted order.
 *
 * (Even though we are representing Intervals in the form [x, y], the objects inside are Intervals,
 * not lists or arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2,
 * and schedule[0][0][0] is not defined).  Also, we wouldn't include intervals like [5, 5] in our answer,
 * as they have zero length.
 *
 * Example 1:
 *
 * Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
 * Output: [[3,4]]
 * Explanation: There are a total of three employees, and all common
 * free time intervals would be [-inf, 1], [3, 4], [10, inf].
 * We discard any intervals that contain inf as they aren't finite.
 *
 *  Example 2:
 *
 * Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
 * Output: [[5,6],[7,9]]
 */

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class EmployeeInterval {
    Interval interval;
    int employeeIndex;
    int intervalIndex;

    EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex) {
        this.interval = interval;
        this.employeeIndex = employeeIndex;
        this.intervalIndex = intervalIndex;
    }
}

public class EmployeeFreeTime {
    public static void main(String[] args) {
        List<List<Interval>> schedule = new ArrayList<>();
        schedule.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        schedule.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = findEmployeeFreeTime(schedule);
        System.out.print("Free intervals: ");
        for(Interval interval : result) {
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        }
        System.out.println();

        schedule = new ArrayList<>();
        schedule.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        schedule.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        schedule.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
        result = findEmployeeFreeTime(schedule);
        System.out.print("Free intervals: ");
        for(Interval interval : result) {
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        }
    }

    private static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();

        PriorityQueue<EmployeeInterval> queue = new PriorityQueue<>((a,b) -> Integer.compare(a.interval.start, b.interval.start));

        for (int i = 0; i < schedule.size(); i++) {
            queue.offer(new EmployeeInterval(schedule.get(i).get(0), i, 0));
        }

        Interval previousInterval = queue.peek().interval;

        while (!queue.isEmpty()) {
            EmployeeInterval topItem = queue.poll();

            if(previousInterval.end < topItem.interval.start) { // no overlap.
                result.add(new Interval(previousInterval.end, topItem.interval.start));
                previousInterval = topItem.interval;
            } else { // overlap
                if (previousInterval.end < topItem.interval.end) {
                    previousInterval = topItem.interval;
                }
            }

            List<Interval> employeeSchedule = schedule.get(topItem.employeeIndex);
            if(employeeSchedule.size() > topItem.intervalIndex + 1) {
                queue.offer(new EmployeeInterval(employeeSchedule.get(topItem.intervalIndex + 1), topItem.employeeIndex, topItem.intervalIndex + 1));
            }
        }
        return result;
    }
}
