package ru.asemenov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.asemenov.models.Item;

import java.sql.Timestamp;
import java.util.List;

public class HiberConnect {
    private static HiberConnect ourInstance = new HiberConnect();

    public static HiberConnect getInstance() {
        return ourInstance;
    }

    private HiberConnect() {
    }

    /**
     * Get all task.
     * @return list.
     */
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

    /**
     * Add new task.
     * @param text String.
     */
    public void addItem(String text) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Item item = new Item();
        item.setDesc(text);
        item.setCreated(new Timestamp(System.currentTimeMillis()));
        item.setDone(false);
        session.save(item);
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    /**
     * Edit state
     * @param id int.
     * @param state boolean.
     */
    public void editState(int id, boolean state) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Item item = session.get(Item.class, id);
        item.setDone(state);
        session.update(item);
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
