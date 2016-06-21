package com.mac.entity.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class BasketballTeamTest {

    @Test
    public void oneToManyTest() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(BasketballTeam.class);
        configuration.addAnnotatedClass(BPlayer.class);

        configuration.configure("hibernate.cfg.xml");

        new SchemaExport(configuration).create(true, true);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        BasketballTeam cavs = new BasketballTeam("CAVS", "Ohio");

        BPlayer lebron = new BPlayer("lebron", "forward");
        lebron.setTeam(cavs);

        BPlayer kyrie = new BPlayer("kyrie", "guard");
        kyrie.setTeam(cavs);

        BPlayer kevin = new BPlayer("kevin", "center");
        kevin.setTeam(cavs);

        List<BPlayer> players = new ArrayList<BPlayer>();
        players.add(lebron);
        players.add(kevin);
        players.add(kyrie);

        cavs.setPlayers(players);

        session.save(cavs);
        session.save(lebron);
        session.save(kevin);
        session.save(kyrie);

        session.getTransaction().commit();

    }

}
