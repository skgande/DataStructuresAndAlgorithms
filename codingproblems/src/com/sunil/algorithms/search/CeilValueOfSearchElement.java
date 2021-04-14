package com.sunil.algorithms.search;

/**
 * Ceil value of element to be searched in an array using binary search.
 */
public class CeilValueOfSearchElement {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 11, 13};
        int x = 10;

        System.out.println("Ceil value is " + getCeilValue(a, 0, a.length, x));
    }

    private static int getCeilValue(int[] a, int low, int high, int ele) {
        while (high-low > 1) {
            int mid = (low + high) / 2;
            if(a[mid] < ele) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return a[high];
    }
}
