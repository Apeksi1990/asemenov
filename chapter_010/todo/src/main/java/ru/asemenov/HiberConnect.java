package ru.asemenov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.asemenov.models.Item;

import java.sql.Timestamp;
import java.util.List;

public class HiberConnect {
    private static final HiberConnect instance = new HiberConnect();

    public static HiberConnect getInstance() {
        return instance;
    }

    private HiberConnect() {
    }

    /**
     * Get all task.
     * @return list.
     */
    public List<Item> getAllItem() {
        SessionFactory factory = null;
        Session session = null;
        List<Item> items = null;
        try {
            factory = new Configuration()
                    .configure()
                    .buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            items = session.createQuery("from Item").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
        return items;
    }

    /**
     * Add new task.
     * @param text String.
     */
    public void addItem(String text) {
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration()
                    .configure()
                    .buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            Item item = new Item();
            item.setDesc(text);
            item.setCreated(new Timestamp(System.currentTimeMillis()));
            item.setDone(false);
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
    }

    /**
     * Edit state
     * @param id int.
     * @param state boolean.
     */
    public void editState(int id, boolean state) {
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration()
                    .configure()
                    .buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            Item item = session.get(Item.class, id);
            item.setDone(state);
            session.update(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
    }
}
