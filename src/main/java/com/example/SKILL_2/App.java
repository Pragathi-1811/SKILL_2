package com.example.SKILL_2;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Hibernate CRUD Operations Example");

        ProductDAO dao = new ProductDAO();

        // ===== CREATE (INSERT) =====
        System.out.println("Inserting new products...");

        Product p1 = new Product();
        p1.setName("Laptop\n");
        p1.setDescription("Dell Inspiron 15\n");
        p1.setPrice(55000);
        p1.setQuantity(10);
        dao.saveProduct(p1);  

        Product p2 = new Product();
        p2.setName("Mouse\n");
        p2.setDescription("Wireless Logitech\n");
        p2.setPrice(1200);
        p2.setQuantity(50);
        dao.saveProduct(p2);  

        Product p3 = new Product();
        p3.setName("Keyboard\n");
        p3.setDescription("Mechanical RGB\n");
        p3.setPrice(3200);
        p3.setQuantity(20);
        dao.saveProduct(p3);

        // ===== UPDATE =====
        System.out.println("Updating product with ID = 2...");
        Product updateProd = new Product();
        updateProd.setId(2);               // existing ID
        updateProd.setName("High-End Mouse");
        updateProd.setDescription("Logitech Wireless PRO");
        updateProd.setPrice(1500);
        updateProd.setQuantity(45);
        dao.updateProduct(updateProd);      // correct update call

        // ===== DELETE =====
        System.out.println("Deleting product with ID = 3...");
        dao.deleteProduct(3);               // correct delete call

        // ===== READ (LIST ALL) =====
        System.out.println("Fetching all products...");
        List<Product> products = dao.getAllProducts();
        for (Product p : products) {
            System.out.println(
                "ID: " + p.getId() +
                " | Name: " + p.getName() +
                " | Desc: " + p.getDescription() +
                " | Price: " + p.getPrice() +
                " | Qty: " + p.getQuantity()
            );
        }

        System.out.println("Operations completed.");
    }
}
