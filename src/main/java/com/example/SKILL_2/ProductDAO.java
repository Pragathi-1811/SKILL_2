package com.example.SKILL_2;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDAO {

    // SAVE / CREATE
    public void saveProduct(Product product) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(product);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updateProduct(Product product) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(product);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteProduct(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Product product = session.get(Product.class, id);
            if (product != null) {
                session.delete(product);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // READ ALL
    public List<Product> getAllProducts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Product", Product.class).list();
        }
    }

    // READ IN ASCENDING ORDER (BY PRICE)
    public List<Product> getProductsAscByPrice() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Product p ORDER BY p.price ASC", Product.class).list();
        }
    }

    // READ IN DESCENDING ORDER (BY PRICE)
    public List<Product> getProductsDescByPrice() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Product p ORDER BY p.price DESC", Product.class).list();
        }
    }

    // READ WITH WHERE (FILTER BY PRICE > given value)
    public List<Product> getProductsWherePriceGreater(Double price) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session
                .createQuery("FROM Product p WHERE p.price > :price", Product.class)
                .setParameter("price", price)
                .list();
        }
    }

    // GROUP BY EXAMPLE (PRICE GROUP COUNT)
    public List<Object[]> getCountByPriceGroup() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session
                .createQuery("SELECT p.price, COUNT(p) FROM Product p GROUP BY p.price", Object[].class)
                .list();
        }
    }


    // OPTIONAL: GET BY ID
    public Product getProductById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Product.class, id);
        }
    }
}
