package com.first.task3.models;

public abstract class Product {
    private String name;
    private String manufacturer;
    private double price;

    public Product(String name, String manufacturer, double price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Manufacturer: " + manufacturer + ", Price: " + price;
    }
}