package com.sunil.puzzles;

/**
 * Print how many small vessels used to prepare target chocolate after using highest possible big vessels.
 *  Small weighs 1 kg and big weighs 5 kg. Return -1 if not possible;
 */
public class ChocolatePuzzle {
    public static void main(String[] args) {
        int small = 4;
        int big = 2;
        int target = 8;
        int smallRequired = makeChocolate(small, big, target);
        System.out.println("smalls required to preapre target chocolate is : " + smallRequired);
    }

    private static int makeChocolate(int small, int big, int target) {
        int goal = target - Math.min(big, target/5) * 5;
        return  (goal <= small) ? goal : -1;
    }
}
