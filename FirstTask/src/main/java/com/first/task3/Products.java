package com.first.task3;

import com.first.task3.models.Product;
import com.first.task3.models.impl.Clothing;
import com.first.task3.models.impl.Food;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Products {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Food("Apple", "Fruit Co.", 2.5, 0.2, "2023-12-31"));
        products.add(new Clothing("T-Shirt", "Clothing Inc.", 15.0, "Cotton", "M"));
        products.add(new Food("Banana", "Fruit Co.", 1.0, 0.15, "2023-12-29"));
        products.add(new Clothing("Jeans", "Clothing Inc.", 50.0, "Denim", "L"));
        products.add(new Clothing("Jeans", "Clothing Inc.", 50.0, "Denim", "M"));
        products.add(new Food("Milk", "Dairy Co.", 3.0, 1.0, "2023-09-30"));

        // Sort products by price
        products.sort(Comparator.comparing(Product::getPrice));
        System.out.println("Sorted Products by Price:");
        for (Product product : products) {
            System.out.println(product);
        }

        // Find clothes of a specified size (e.g., "M")
        String targetSize = "M";
        System.out.println("\nClothing of Size " + targetSize + ":");
        for (Product product : products) {
            if ((product instanceof Clothing) && ((Clothing) product).getSize().equals(targetSize)) {
                System.out.println(product);
            }
        }

        // Find food products with a maximum expiration date
        List<Food> foodList = products.stream()
                .filter(Food.class::isInstance)
                .map(Food.class::cast)
                .max(Comparator.comparing(Food::getShelfLife))
                .stream().toList();

        System.out.println("\nFood with max expiration date:");
        for (Product product : foodList) {
            System.out.println(product);
        }
    }
}
