package com.sunil.algorithms.sort;

/**
 * Perform selection sort: At each iteration min element is going to be placed at the begining.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {64, 25, 12, 22, 11};
        a = performSelectionSort(a);
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }

    private static int[] performSelectionSort(int[] a) {
        for(int i = 0; i < a.length; i++) {
            int minIndex = i;
            int minValue = a[i];

            for(int j = i; j < a.length; j++) {
                if (minValue > a[j]) {
                    minIndex = j;
                    minValue = a[j];
                }
            }

            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;

        }
        return a;
    }
}
