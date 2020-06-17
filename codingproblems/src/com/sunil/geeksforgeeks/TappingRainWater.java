package com.sunil.geeksforgeeks;

/**
 * Given array of +ve elements is the height of polls and if the rain falls
 * how many unit of water can be stored.
 *
 * Ex: [3, 0, 2, 0, 4] --> Output will be 7 units of water.
 */
public class TappingRainWater {
    public static void main(String[] args) {
        int[] a = {3, 0, 2, 0, 4};
        int result = findWaterStorage(a);

        System.out.println("Number of units can be stored are " + result);
    }

    private static int findWaterStorage(int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        int result = 0;
        int leftMax = 0;
        int rightMax = 0;

        while(lo < hi) {
            if(a[lo] < a[hi]) {
                if(a[lo] > leftMax) {
                    leftMax = a[lo];
                } else {
                    result = result + leftMax - a[lo];
                }
                lo++;
            } else {
                if(a[hi] > rightMax) {
                    rightMax = a[hi];
                } else {
                    result = result + rightMax -a[hi];
                }
                hi--;
            }
        }
        return result;
    }
}
