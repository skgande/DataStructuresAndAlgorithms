package com.sunil.leetcode.dd;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * There are n engineers numbered from 1 to n and two arrays: speed and efficiency,
 * where speed[i] and efficiency[i] represent the speed and efficiency for the
 * i-th engineer respectively.
 * Return the maximum performance of a team composed of at most k engineers,
 * since the answer can be a huge number, return this modulo 10^9 + 7.
 * <p>
 * The performance of a team is the sum of their engineers' speeds
 * multiplied by the minimum efficiency among their engineers.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
 * Output: 60
 * Explanation:
 * We have the maximum performance of the team by selecting engineer 2
 * (with speed=10 and efficiency=4) and engineer 5 (with speed=5 and efficiency=7).
 * That is, performance = (10 + 5) * min(4, 7) = 60.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 3
 * Output: 68
 * Explanation:
 * This is the same example as the first but k = 3. We can select engineer 1,
 * engineer 2 and engineer 5 to get the maximum performance of the team.
 * That is, performance = (2 + 10 + 5) * min(5, 4, 7) = 68.
 * Example 3:
 * <p>
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 4
 * Output: 72
 */
public class MaxPerformanceOfTeam {
    public static void main(String[] args) {
        int n = 6;
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        int k = 2;

        System.out.println("Max performance of team is : " + maxPerformanceOfTeam(n, speed, efficiency, k));
    }

    private static int maxPerformanceOfTeam(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][];

        for (int i = 0; i < n; i++) {
            engineers[i] = new int[]{efficiency[i], speed[i]};
        }

        Arrays.sort(engineers, (int[] a, int[] b) -> (b[0] -a[0]));

        long sum = 0, result = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for (int[] engineer : engineers) {
            sum = sum + engineer[1];
            pq.offer(engineer[1]);

            if (pq.size() > k) {
               sum = sum - pq.poll();
            }
            result = Math.max(result, sum * engineer[0]);
        }
        return (int) (result % (long) (1e9 + 7));
    }
}
