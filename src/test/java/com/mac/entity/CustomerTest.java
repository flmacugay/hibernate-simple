package com.mac.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class CustomerTest {

	@Test
	public void test() {
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Customer.class);

		configuration.configure("hibernate.cfg.xml");

		new SchemaExport(configuration).create(true, true);

		Customer cowboy = new Customer("Cowboy", 1250, "Melbourne");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);

		final Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		{
			session.save(cowboy);
		}

		session.getTransaction().commit();
	}

}
