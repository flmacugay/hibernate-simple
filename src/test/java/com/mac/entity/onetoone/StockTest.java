package com.mac.entity.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class StockTest {

    @Test
    public void oneToOneTest() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Stock.class);
        configuration.addAnnotatedClass(StockDetail.class);

        configuration.configure("hibernate.cfg.xml");

        new SchemaExport(configuration).create(true, true);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Stock stock = new Stock("Laptops");
        StockDetail detail = new StockDetail("HP", "Available");

        stock.setStockDetail(detail);
        detail.setStock(stock);

        session.save(stock);
        session.save(detail);

        session.getTransaction().commit();

    }
}
