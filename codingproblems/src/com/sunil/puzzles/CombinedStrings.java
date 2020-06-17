package com.sunil.puzzles;

/** Program to print combination od strings with the constraint mentioned in below.
 *
 * Given N strings consisting of ‘R’ and ‘B’. Two strings can be only combined if last
 * character of first string and first character of second string are same.
 * Print the maximum length possible by combining strings.
 *
 * Ex: if the input is "RBR", "BBR" and "RRR" then the combined string becomes
 * "BBRRRRRBR" and the length is 9 (which is also an output) which should be returned.
 */
public class CombinedStrings {
    public static void main(String args[]) {
        String[] inputs = {"RBR", "BBR", "RRR"};
        String isRR = "";
        String isRB = "";
        String isBR = "";
        String isBB = "";

        for(String str : inputs) {
            if(str.charAt(0) == 'R' && str.charAt(str.length() -1) == 'R') {
                isRR = isRR + str;
            } else if(str.charAt(0) == 'R' && str.charAt(str.length() -1) == 'B') {
                isRB = isRB + str;
            } else if(str.charAt(0) == 'B' && str.charAt(str.length() -1) == 'R') {
                isBR = isBR + str;
            } else if(str.charAt(0) == 'B' && str.charAt(str.length() -1) == 'B') {
                isBB = isBB +str;
            } else {
                System.out.println("Invalid inputs");
            }
        }

        String startsWithR = isRR + isRB;
        String startsWithB = isBB + isBR;
        String finalString = "";
        if((startsWithR.charAt(startsWithR.length() -1) == 'R' && startsWithB.charAt(startsWithB.length() - 1) == 'R') ||
                (startsWithR.charAt(startsWithR.length() -1) == 'B' && startsWithB.charAt(0) == 'B')) {
            finalString = startsWithR + startsWithB;
        }
        System.out.println("Length of combined string is " + finalString.length());
    }
}
