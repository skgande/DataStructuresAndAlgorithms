package com.sunil.leetcode.doordash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You are given an inclusive range [lower, upper] and a sorted unique integer array nums,
 * where all elements are in the inclusive range.
 * A number x is considered missing if x is in the range [lower, upper] and x is not in nums.
 * <p>
 * Return the smallest sorted list of ranges that cover every missing number exactly.
 * That is, no element of nums is in any of the ranges, and each missing number is in one of the ranges.
 * <p>
 * Each range [a,b] in the list should be output as:
 * "a->b" if a != b
 * "a" if a == b
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,3,50,75], lower = 0, upper = 99
 * Output: ["2","4->49","51->74","76->99"]
 * Explanation: The ranges are:
 * [2,2] --> "2"
 * [4,49] --> "4->49"
 * [51,74] --> "51->74"
 * [76,99] --> "76->99"
 */
public class MissingRanges {
    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0, upper = 99;

        System.out.println("Missing ranges are " + missingRanges(nums, lower, upper));
    }

    private static List<String> missingRanges(int[] nums, int lower, int upper) {
        if (nums.length == 0) {
            return Collections.singletonList(makeRange(lower, upper));
        }

        List<String> result = new ArrayList<>();
        if (lower < nums[0]) {
            result.add(makeRange(lower, nums[0]));
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }

            if (nums[i] != nums[i + 1] - 1) {
                result.add(makeRange(nums[i] + 1, nums[i + 1] - 1));
            }
        }

        if (nums[nums.length - 1] < upper) {
            result.add(makeRange(nums[nums.length - 1] + 1, upper));
        }

        return result;
    }

    private static String makeRange(int a, int b) {
        return a == b ? String.valueOf(a) : (a + "->" + b);
    }
}
