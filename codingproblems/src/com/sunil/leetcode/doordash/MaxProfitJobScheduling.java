package com.sunil.leetcode.doordash;

import java.util.Arrays;

/**
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
 * <p>
 * You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that
 * there are no two jobs in the subset with overlapping time range.
 * <p>
 * If you choose a job that ends at time X you will be able to start another job that starts at time X.
 * <p>
 * Example 1:
 * Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * Output: 120
 * Explanation: The subset chosen is the first and fourth job.
 * Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
 * <p>
 * Example 2:
 * Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
 * Output: 150
 * Explanation: The subset chosen is the first, fourth and fifth job.
 * Profit obtained 150 = 20 + 70 + 60.
 * <p>
 * Example 3:
 * Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
 * Output: 6
 */
class Job {
    int start;
    int end;
    int profit;

    public Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

public class MaxProfitJobScheduling {
    public static void main(String[] args) {
        Job jobs[] = new Job[4];
        jobs[0] = new Job(1, 3, 50);
        jobs[1] = new Job(2, 4, 10);
        jobs[2] = new Job(3, 5, 40);
        jobs[3] = new Job(3, 6, 70);

        System.out.println("Max profit while job scheduling " + maxProfitJobSchedule(jobs));
    }

    private static int maxProfitJobSchedule(Job[] jobs) {
        Arrays.sort(jobs, (a, b) -> a.end - b.end);

        int[] dp = new int[jobs.length];
        dp[0] = jobs[0].profit;

        for(int i = 1; i < jobs.length; i++) {
            dp[i] = Math.max(jobs[i].profit, dp[i-1]);

            for(int j = i - 1; j >= 0; j--) {
                if (jobs[j].end <= jobs[i].start) {
                    dp[i] = Math.max(dp[i], jobs[i].profit + dp[j]);
                    break;
                }
            }
        }

        int maxValue = Integer.MIN_VALUE;
        for (int v: dp) {
            if(maxValue < v) {
                maxValue = v;
            }
        }
        return maxValue;
    }
}
