package com.sunil.leetcode.arrays;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return
 * the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with
 * O(1) extra memory.
 *
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] a = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("Index " + rearrangeArray(a));
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static int rearrangeArray(int[] a) {
        int index  = 0;
        for(int i = 0; i < a.length; i++){
            if(i == 0) {
                a[index] = a[i];
            } else if(a[index] == a[i]) {
            } else {
                int temp = a[index + 1];
                a[++index] = a[i];
                a[i] = temp;
            }
        }
        return index + 1;
    }
}
