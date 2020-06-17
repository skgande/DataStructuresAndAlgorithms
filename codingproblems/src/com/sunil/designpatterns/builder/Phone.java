package com.sunil.designpatterns.builder;

public class Phone {
    private String operatingSystem;
    private int price;
    private float screenSize;
    private String processor;

    public Phone(String operatingSystem, int price, float screenSize, String processor) {
        this.operatingSystem = operatingSystem;
        this.price = price;
        this.screenSize = screenSize;
        this.processor = processor;
    }

    public String toString() {
        return "PhoneNumber[ operatingSystem " + operatingSystem + " price " + price + " processor " + processor +
                " screen size " +  screenSize +"]";
    }
}
