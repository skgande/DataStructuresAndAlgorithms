package com.sunil.algorithms.search;

/**
 * Find number of occurrences of given element in an array using binary search.
 */
public class FindOccurrencesOfElement {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 2, 2, 2, 4, 5, 6};
        int x = 2;

        int floorIndex = getFloorIndex(a, 0, a.length, x);
        int ceilIndex = getCeilIndex(a, 0, a.length, x);

        System.out.println("Number of occurrences of " + x + " is " + (ceilIndex - floorIndex + 1));
    }

    private static int getFloorIndex(int[] a, int low, int high, int ele) {
        while (high - low > 1) {
            int mid = (low + high) / 2;

            if(a[mid] < ele) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return a[low] == a[high] ? low : high;
    }

    private static int getCeilIndex(int[] a, int low, int high, int ele) {
        while (high - low > 1) {
            int mid = (low + high) / 2;

            if(a[mid] <= ele) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return a[low] == a[high] ? high : low;
    }
}
