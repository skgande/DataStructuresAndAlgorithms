package com.sunil.recursion;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("one");
        strList.add("two");
        System.out.println("'" + String.join("','", strList) + "'");
    }
}
