package ru.asemenov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.asemenov.models.Item;

import java.util.List;

public class HiberConnect {
    private static HiberConnect ourInstance = new HiberConnect();

    public static HiberConnect getInstance() {
        return ourInstance;
    }

    private HiberConnect() {
    }

    public List<Item> getAllItem() {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        List<Item> items = session.createQuery("from Item").list();
        session.getTransaction().commit();
        session.close();
        factory.close();
        return items;
    }
}
