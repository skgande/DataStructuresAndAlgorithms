package com.sunil.algorithms.search;

/**
 * Check element exists or not in a bitonic array.
 * Bitonic array is the array first in increasing order then decreasing order.
 *
 */
public class CheckElementInBitonicArray {
    public static void main(String[] args) {
        int[] a = {6, 7, 8, 9, 10, 5, 4, 3};
        int n = 9;

        if(isElementExists(a, n)) {
            System.out.println("Element is present");
        } else {
            System.out.println("Element is not present");
        }
    }

    private static boolean isElementExists(int[] a, int ele) {
        int n = getBitonicIndex(a, 0, a.length-1);
        if(a[n] == ele) {
            return true;
        } else if(a[n] < ele) {
            return false;
        }
        return isPresentinAscArray(a, 0, n, ele) || isPresentInDescArray(a, n+1, a.length-1, ele);
    }

    private static int getBitonicIndex(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if(a[mid] > a[mid-1] && a[mid+1] < a[mid]) {
            return mid;
        }
        if(a[mid] < a[mid+1]) {
            return getBitonicIndex(a, mid, high);
        }
        return getBitonicIndex(a, low, mid);
    }

    private static boolean isPresentinAscArray(int[] a, int low, int high, int n) {
        int mid = (low + high)/2;

        if(mid == 0 && a[mid] != n) {
            return false;
        }

        if(a[mid] == n) {
            return true;
        }

        if(a[mid] > n) {
            return isPresentinAscArray(a, low, mid, n);
        }
        return isPresentinAscArray(a, mid, high, n);
    }

    private static boolean isPresentInDescArray(int[] a, int low, int high, int n) {
        int mid = (low + high)/2;
        if(a[low] == n) {
            return true;
        } else if(mid == a.length -2) {
            if(a[mid] == n || a[a.length-1] == n) {
                return true;
            }
            return false;
        }

        if(a[mid] <  n) {
            return isPresentInDescArray(a, low, mid, n);
        }
        return isPresentInDescArray(a, mid, high, n);
    }
}
