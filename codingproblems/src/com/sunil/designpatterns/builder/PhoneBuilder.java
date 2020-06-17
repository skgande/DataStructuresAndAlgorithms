package com.sunil.designpatterns.builder;

public class PhoneBuilder {
    private String operatingSystem;
    private int price;
    private float screenSize;
    private String processor;

    public PhoneBuilder setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
        return this;
    }

    public PhoneBuilder setPrice(int price) {
        this.price = price;
        return this;
    }

    public PhoneBuilder setScreenSize(float screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    public PhoneBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public Phone build() {
        return new Phone(operatingSystem, price, screenSize, processor);
    }
}
