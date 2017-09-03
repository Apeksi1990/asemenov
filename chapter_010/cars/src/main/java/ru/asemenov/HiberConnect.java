package ru.asemenov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.asemenov.models.Car;

import java.util.List;

public class HiberConnect {
    private static volatile HiberConnect instance = new HiberConnect();

    public static HiberConnect getInstance() {
        if (instance == null) {
            synchronized (HiberConnect.class) {
                if (instance == null) {
                    instance = new HiberConnect();
                }
            }
        }
        return instance;
    }

    private HiberConnect() {
    }

    public List<Car> getAllCars() {
        SessionFactory factory = null;
        Session session = null;
        List<Car> cars = null;
        try {
            factory = new Configuration()
                    .configure()
                    .buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            cars = session.createQuery("from Car").list();
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
        return cars;
    }
}
