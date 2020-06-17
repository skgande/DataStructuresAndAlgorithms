package com.sunil.algorithms.sort;

import java.util.Arrays;

/**
 * Bubble Sort: It is a technique and during first iteration highest element of array is going to be placed at the end
 * and so on. Opposite to selection sort.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {5, 3, 7, 9, 1, 4, 8, 2, 6};
        performBubbleSort(a);
        Arrays.stream(a).forEach(System.out::print);
    }

    private static void performBubbleSort(int[] a) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n-i-1; j++) {
                if(a[j] > a[j+1]) {
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
