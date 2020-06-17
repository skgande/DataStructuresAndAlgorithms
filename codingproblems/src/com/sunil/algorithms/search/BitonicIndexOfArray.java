package com.sunil.algorithms.search;

/**
 * Bitonic index of array is an index of array starting from 0 to that index is in increasing order and then followed by
 * decreasing order.
 *
 * Ex: {6, 7, 8, 9, 10, 5, 4, 3} bitonic index is 4.
 */
public class BitonicIndexOfArray {
    public static void main(String[] args) {
        int[] a = {6, 7, 8, 9, 10, 5, 4, 3};
        int bitonicIndex = findBitonicIndex(a, 0, a.length-1);
        System.out.println("Bitonic Index of an array is " + bitonicIndex);
    }

    private static int findBitonicIndex(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if(a[mid-1] < a[mid] && a[mid] > a[mid+1]) {
            return mid;
        }

        return (a[mid] < a[mid+1]) ? findBitonicIndex(a, mid, high): findBitonicIndex(a, low, mid);
    }
}
