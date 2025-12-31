package com.example.SKILL_2;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Hibernate CRUD Operations Example");

        ProductDAO dao = new ProductDAO();

        // ===== CREATE =====
        System.out.println("\nInserting new products...");

        Product p1 = new Product();
        p1.setName("Laptop");
        p1.setDescription("Dell Inspiron 15");
        p1.setPrice(55000);
        p1.setQuantity(10);
        dao.saveProduct(p1);

        Product p2 = new Product();
        p2.setName("Mouse");
        p2.setDescription("Wireless Logitech");
        p2.setPrice(1200);
        p2.setQuantity(50);
        dao.saveProduct(p2);

        Product p3 = new Product();
        p3.setName("Keyboard");
        p3.setDescription("Mechanical RGB");
        p3.setPrice(3000);
        p3.setQuantity(20);
        dao.saveProduct(p3);

        Product p4 = new Product();
        p4.setName("Speaker");
        p4.setDescription("Bluetooth Speaker");
        p4.setPrice(2500);
        p4.setQuantity(20);
        dao.saveProduct(p4);

        Product p5 = new Product();
        p5.setName("Webcam");
        p5.setDescription("HD Webcam");
        p5.setPrice(4200);
        p5.setQuantity(20);
        dao.saveProduct(p5);

        // ===== READ ALL =====
        System.out.println("\nFetching all products...");
        List<Product> products = dao.getAllProducts();
        for (Product p : products) {
            System.out.println(
                "ID: " + p.getId() +
                " | Name: " + p.getName() +
                " | Price: " + p.getPrice()
            );
        }

        // ===== ASCENDING ORDER =====
        System.out.println("\nProducts in ASCENDING order by price:");
        List<Product> ascProducts = dao.getProductsAscByPrice();
        for (Product p : ascProducts) {
            System.out.println("Name: " + p.getName() + " | Price: " + p.getPrice());
        }

        // ===== DESCENDING ORDER =====
        System.out.println("\nProducts in DESCENDING order by price:");
        List<Product> descProducts = dao.getProductsDescByPrice();
        for (Product p : descProducts) {
            System.out.println("Name: " + p.getName() + " | Price: " + p.getPrice());
        }

        // ===== WHERE FILTER =====
        System.out.println("\nProducts with price > 3000:");
        List<Product> filtered = dao.getProductsWherePriceGreater(3000.0);
        for (Product p : filtered) {
            System.out.println("Name: " + p.getName() + " | Price: " + p.getPrice());
        }

        // ===== GROUP BY =====
        System.out.println("\nGroup by price (price vs count):");
        List<Object[]> groups = dao.getCountByPriceGroup();
        for (Object[] row : groups) {

            // Safely convert to Number first
            Number priceNumber = (Number) row[0];
            Number countNumber = (Number) row[1];

            double priceValue = priceNumber.doubleValue();
            long countValue = countNumber.longValue();

            System.out.println("Price: " + priceValue + " | Count: " + countValue);
        }

        System.out.println("\nOperations completed.");
    }
}
