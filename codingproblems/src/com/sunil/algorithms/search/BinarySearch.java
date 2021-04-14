package com.sunil.algorithms.search;

/**
 * Program to search element in an array using binary search.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50, 60, 70};
        int x = 50;

        int searchIndex = performBinarySearch(a, 0, a.length, x);

        if(searchIndex == -1){
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at " + searchIndex);
        }
    }

    private static int performBinarySearch(int[] a, int low, int high, int ele) {
        while (low < high) {
            int mid = (low + high) / 2;
            if(a[mid] == ele) {
                return mid;
            }

            if(a[mid] < ele) {
                high = mid + 1;
            } else {
                low = mid;
            }
        }
        return -1;
    }
}
