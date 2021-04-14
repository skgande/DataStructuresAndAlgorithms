package com.sunil.pytojava.basics;

import java.util.HashSet;
import java.util.Set;

public class DistinctElementsInArray {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 2, 3, 2, 3, 2, 4, 2, 4, 3, 5};

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }

        System.out.println(set);
    }
}
