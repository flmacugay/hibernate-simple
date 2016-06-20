package com.mac.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class VehicleTest {

	@Test
	public void inheritanceTest() {
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Vehicle.class);
		configuration.addAnnotatedClass(Car.class);
		configuration.addAnnotatedClass(Sedan.class);

		configuration.configure("hibernate.cfg.xml");

		new SchemaExport(configuration).create(true, true);

		final Vehicle vehicle = new Vehicle("V6");

		final Car car = new Car("Audi");
		car.setEngine("Boost");

		final Sedan sedan = new Sedan("Sport");
		sedan.setEngine("V8");
		sedan.setMake("Mazda");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);

		final Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		session.save(vehicle);

		session.save(car);

		session.save(sedan);

		session.getTransaction().commit();

	}

}
