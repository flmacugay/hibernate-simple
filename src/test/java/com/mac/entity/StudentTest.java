package com.mac.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class StudentTest {

	@Test
	public void embeddableTest() {
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Student.class);

		configuration.configure("hibernate.cfg.xml");

		new SchemaExport(configuration).create(true, true);

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);

		final Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		StudentDetails lebronDetails = new StudentDetails(2016, "basketball",
				"nba", "lbj@nba.com");
		Student lebron = new Student("Lebron", lebronDetails);

		session.save(lebron);

		session.getTransaction().commit();

	}

}
