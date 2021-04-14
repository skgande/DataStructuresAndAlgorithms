package com.sunil.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such
 * that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] a = {4, 5, 11, 15};
        int target = 9;

        Map<Integer, Integer> numberToIndexMap = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            // After knowing the current value of an array, find the remaining value required to meet target.
            int valueNeededForTarget = target - a[i];

            // The difference is already present map then we got the indexes and stop the process.
            if(numberToIndexMap.containsKey(valueNeededForTarget)) {
                System.out.println("Result is " + numberToIndexMap.get(valueNeededForTarget) + " and " + i);
                break;
            }

            // Here no indexes find for the target and remember visited values in array by storing it in map.
            numberToIndexMap.put(a[i], i);
        }
    }
}
