package com.mac.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class EmployeeTest {

	@Test
	public void annotationTest() {

		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Employee.class);

		configuration.configure("hibernate.cfg.xml");

		new SchemaExport(configuration).create(true, true);

		Employee steve = new Employee("Steve Jobs");
		steve.setDob(new GregorianCalendar(1960, 1, 1).getTime());
		steve.setEmailAddress("apple@mac.com");
		steve.setPermanent(true);
		steve.setSalary(BigDecimal.valueOf(12000.56));
		steve.setTimeIn(new Date());

		Employee joshua = new Employee("Joshua Bloch");
		joshua.setDob(new GregorianCalendar(1965, 1, 1).getTime());
		joshua.setEmailAddress("java@mac.com");
		joshua.setPermanent(false);
		joshua.setSalary(BigDecimal.valueOf(15000.56));
		joshua.setTimeIn(new Date());

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);

		final Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		{
			session.save(steve);
		}
		{
			session.save(joshua);
		}

		session.getTransaction().commit();

	}

}
