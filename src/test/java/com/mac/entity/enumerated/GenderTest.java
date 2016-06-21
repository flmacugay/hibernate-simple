package com.mac.entity.enumerated;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class GenderTest {

	@Test
	public void enumeratedTest() {
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Person.class);

		configuration.configure("hibernate.cfg.xml");

		new SchemaExport(configuration).create(true, true);

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Person jordan = new Person("Michael Jordan", Gender.MALE);
		Person taylor = new Person("Taylor Swift", Gender.FEMALE);

		session.save(jordan);
		session.save(taylor);

		session.getTransaction().commit();

	}

}
