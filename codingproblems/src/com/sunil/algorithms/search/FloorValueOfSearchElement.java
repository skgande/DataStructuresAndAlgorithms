package com.sunil.algorithms.search;

/**
 * Program to find floor value of search element in an array using binary search.
 */
public class FloorValueOfSearchElement {
    public static void main(String[] args) {
        int[] a = {-1, 3, 5, 7, 8, 9, 11};
        int x = 1;

        System.out.println("Floor value is " + getFloorValue(a, 0, a.length, x));
    }

    private static int getFloorValue(int[] a, int low, int high, int ele) {
        while((high -low) > 1) {
            int mid = (high + low) / 2;
            if(a[mid] <= ele) {
                low = mid;
            } else{
                high = mid;
            }
        }
        return a[low];
    }
}
