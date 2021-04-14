package com.sunil.pytojava.basics;

import java.util.stream.IntStream;

public class Factorial {
    public static void main(String[] args) {
        int a = 5;
        int result = IntStream.rangeClosed(1, a).reduce(1, (int x, int y) -> x * y);
        System.out.println(result);
    }
}
