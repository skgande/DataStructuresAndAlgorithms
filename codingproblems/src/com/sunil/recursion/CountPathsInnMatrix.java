package com.sunil.recursion;

/**
 * Program to find number of paths possible to to reach from top left to bottom right of m X n matrix.
 * */
public class CountPathsInnMatrix {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;

        int result = getPathsCount(m, n);
        System.out.println("Number of paths in matrix are " + result);
    }

    private static int getPathsCount(int m, int n) {
        if(m == 1 || n == 1) {
            return 1;
        }

        return getPathsCount(m-1, n) + getPathsCount(m, n-1);
        // If the diagonal paths are allowed then include recursive call combination of (m-1, n-1).
        // return countNumberOfPaths(m-1, n) + countNumberOfPaths(m, n-1) + countNumberOfPaths(m-1, n-1);
    }
}
