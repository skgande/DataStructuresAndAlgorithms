package com.sunil.algorithms.search;

/**
 * Find min element of 'n' times rotated sorted array using binary search.
 */
public class MinElementInRotatedSortedArray {
    public static void main(String[] args) {
        int[] a = {60, 70, 10, 20, 30, 40, 50};
        System.out.println("Min ele of rotated sorted array is " + getMinElement(a, 0, a.length-1));
    }

    private static int getMinElement(int[] a, int low, int high) {
        while (low <= high) {
            if(low == high) {
                return a[low];
            }

            int mid = (low + high) / 2;

            if(a[mid] <= a[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
