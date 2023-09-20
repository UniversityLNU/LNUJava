package com.first.task3.models.impl;

import com.first.task3.models.Product;

public class Food extends Product {
    private double weight;
    private String shelfLife;

    public Food(String name, String manufacturer, double price, double weight, String shelfLife) {
        super(name, manufacturer, price);
        this.weight = weight;
        this.shelfLife = shelfLife;
    }

    public String getShelfLife() {
        return shelfLife;
    }

    @Override
    public String toString() {
        return super.toString() + ", Weight: " + weight + ", Shelf Life: " + shelfLife;
    }
}
