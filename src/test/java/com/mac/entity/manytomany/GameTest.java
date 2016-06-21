package com.mac.entity.manytomany;

import java.util.Arrays;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class GameTest {

    @Test
    public void manyToManyTest() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Game.class);
        configuration.addAnnotatedClass(Team.class);

        configuration.configure("hibernate.cfg.xml");

        new SchemaExport(configuration).create(true, true);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Game regularGame = new Game("regular", new Date());
        Game playoffGame = new Game("playoff", new Date());

        Team cavs = new Team("CAVS");
        Team gsw = new Team("GSW");

        regularGame.setTeams(Arrays.asList(cavs, gsw));
        playoffGame.setTeams(Arrays.asList(cavs, gsw));

        cavs.setGames(Arrays.asList(regularGame, playoffGame));
        gsw.setGames(Arrays.asList(regularGame, playoffGame));

        session.save(regularGame);
        session.save(playoffGame);
        session.save(cavs);
        session.save(gsw);

        session.getTransaction().commit();

    }

}
