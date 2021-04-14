package com.sunil.leetcode.dd;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that
 * i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, 4};

        List<List<Integer>> results = threeSum(nums);

        for(List<Integer> result : results) {
            System.out.println(result);
        }
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> results = new ArrayList<>();

        for(int i = 0; i < n - 2; i++) {
            if(i == 0 || nums[i] != nums[i-1]) {
                int j = i + 1, k = n - 1;

                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if(sum == 0) {
                        List<Integer> result = new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        results.add(result);

                        while (j < k && nums[j] == nums[j+1]) j++;
                        while (j < k && nums[k] == nums[k-1]) k--;
                        j++;
                        k--;
                    } else if(sum > 0) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return results;
    }
}
