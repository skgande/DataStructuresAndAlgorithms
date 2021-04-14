package com.sunil.pytojava.basics;

import java.util.Arrays;

public class AlternateCharactersOfString {
    public static void main(String[] args) {
        String givenString = "sample string";
        String result = "";
        for (int i = 0; i < givenString.length(); i = i+2) {
            result = result + givenString.charAt(i);
        }
        System.out.println("Alternate characters of string : " + result);
    }
}
