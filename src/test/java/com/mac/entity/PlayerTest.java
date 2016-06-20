package com.mac.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class PlayerTest {

	@Test
	public void compoundKey() {
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Player.class);

		configuration.configure("hibernate.cfg.xml");

		new SchemaExport(configuration).create(true, true);

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);

		final Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		PlayerKey key = new PlayerKey("Kyrie", 2);
		Player kyrie = new Player(key, "CAVS", "basketball");

		session.save(kyrie);

		session.getTransaction().commit();

	}

}
