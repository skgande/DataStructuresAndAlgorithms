package com.sunil.leetcode.doordash;

/**
 * We are given an array A of positive integers, and two positive integers L and R (L <= R).
 *
 * Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that
 * subarray is at least L and at most R.
 *
 * Example :
 * Input:
 * A = [2, 1, 4, 3]
 * L = 2
 * R = 3
 * Output: 3
 * Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
 */
public class NumSubArraysWithBoundedMaximum {
    public static void main(String[] args) {
        int[] a = {2, 1, 4, 3};
        int l = 2, r = 3;

        System.out.println("Number of max sub arrays with bounded maximum are : " + numSubArrayBoundedMax(a, l, r));
    }

    private static int numSubArrayBoundedMax(int[] a, int l, int r) {
        return countBoundedArrays(a, r) - countBoundedArrays(a, l - 1);
    }

    private static int countBoundedArrays(int[] a, int bounded) {
        int count = 0, temp = 0;
        for (int value : a) {
            if(value <= bounded) {
                temp = temp + 1;
                count = count + temp;
            } else {
                temp = 0;
            }
        }
        return count;
    }
}
