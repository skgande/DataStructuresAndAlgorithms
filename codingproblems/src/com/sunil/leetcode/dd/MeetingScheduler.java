package com.sunil.leetcode.dd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration,
 * return the earliest time slot that works for both of them and is of duration duration.
 * <p>
 * If there is no common time slot that satisfies the requirements, return an empty array.
 * <p>
 * The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.
 * <p>
 * It is guaranteed that no two availability slots of the same person intersect with each other. That is,
 * for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.
 * <p>
 * Example 1:
 * <p>
 * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
 * Output: [60,68]
 * Example 2:
 * <p>
 * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
 * Output: []
 */
public class MeetingScheduler {
    public static void main(String[] args) {
        int[][] slots1 = {{10, 50}, {60, 120}, {140, 210}};
        int[][] slots2 = {{0, 15}, {60, 70}};
        int duration = 8;

        List<Integer> result = minAvailableDuration(slots1, slots2, duration);

        System.out.print(" The duration is : [");
        for (Integer r : result) {
            System.out.print(" " + r);
        }
        System.out.print(" ]");
    }

    private static List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        if (slots1.length == 0 || slots2.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(slots1, (a1, a2) -> a1[0] - a2[0]);
        Arrays.sort(slots2, (a1, a2) -> a1[0] - a2[0]);

        int a = 0;
        int b = 0;
        while (true) {
            int lastStart = Math.max(slots1[a][0], slots2[b][0]);
            int firstEnd = Math.min(slots1[a][1], slots2[b][1]);

            if (firstEnd - lastStart >= duration) {
                List<Integer> result = new ArrayList<>();
                result.add(lastStart);
                result.add(lastStart + duration);
                return result;
            } else {
                if (slots1[a][1] == firstEnd) {
                    a++;
                }
                if (slots2[b][1] == firstEnd) {
                    b++;
                }
                if (a == slots1.length) {
                    break;
                }
                if (b == slots2.length) {
                    break;
                }
            }
        }
        return new ArrayList<>();
    }
}
