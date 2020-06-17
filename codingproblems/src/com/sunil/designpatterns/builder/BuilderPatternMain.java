package com.sunil.designpatterns.builder;

public class BuilderPatternMain {
    public static void main(String[] args) {
        Phone phone = new PhoneBuilder().setOperatingSystem("Android").setPrice(1000).setScreenSize(5.0f).build();
        System.out.println("Phone object " + phone.toString());
    }
}
