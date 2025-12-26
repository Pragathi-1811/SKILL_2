package com.example.SKILL_2;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	// Single SessionFactory instance for the application
    private static SessionFactory sessionFactory;

    // Static block initializes SessionFactory when class is loaded
    static {
        try {
        	StandardServiceRegistry ssr =
                    new StandardServiceRegistryBuilder()
                            .configure("hibernate.cfg.xml")
                            .build();
        	 Metadata metadata =
                     new MetadataSources(ssr)
                             .getMetadataBuilder()
                             .build();
        	 sessionFactory =
                     metadata.getSessionFactoryBuilder().build();

         } catch (Exception e) {
             e.printStackTrace();
         }
     }

     // Provides access to SessionFactory for DAO classes
     public static SessionFactory getSessionFactory() {
         return sessionFactory;
        	
        }
}
