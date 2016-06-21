package com.mac.entity.namedquery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class UserTest {

    @Test
    public void namedQueryTest() {

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);

        configuration.configure("hibernate.cfg.xml");

        new SchemaExport(configuration).create(true, true);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        final Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        User tom = new User("Tom");
        User jerry = new User("Jerry");
        User sylvester = new User("Sylvester");

        session.save(tom);
        session.save(jerry);
        session.save(sylvester);

        session.getTransaction().commit();

    }

    @Test
    public void getUserTest() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);

        configuration.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        final Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        final Query userQuery = session.getNamedQuery("User.byId");
        userQuery.setInteger(0, 1);

        final User userById = (User) userQuery.list().get(0);

        System.out.println(userById.getName() + " id is " + userById.getUserId());

        final Query userNameQuery = session.getNamedQuery("User.byName");
        userNameQuery.setString(0, "Jerry");

        final User userByName = (User) userNameQuery.list().get(0);

        System.out.println(userByName.getName() + " id is " + userByName.getUserId());
    }

}
