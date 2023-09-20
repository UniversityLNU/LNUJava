package com.first.task3.models.impl;

import com.first.task3.models.Product;

public class Clothing extends Product {
    private String fabric;
    private String size;

    public Clothing(String name, String manufacturer, double price, String fabric, String size) {
        super(name, manufacturer, price);
        this.fabric = fabric;
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return super.toString() + ", Fabric: " + fabric + ", Size: " + size;
    }
}