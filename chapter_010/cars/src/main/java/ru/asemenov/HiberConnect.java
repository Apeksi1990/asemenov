package ru.asemenov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.asemenov.models.Car;
import ru.asemenov.models.Mark;
import ru.asemenov.models.Model;
import ru.asemenov.models.User;

import java.util.List;

public class HiberConnect {
    private static final HiberConnect instance = new HiberConnect();

    public static HiberConnect getInstance() {
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
            for (Car c: cars) {
                System.out.println(c);
            }
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

    public Car getCarById(int id) {
        SessionFactory factory = null;
        Session session = null;
        Car car = null;
        try {
            factory = new Configuration()
                    .configure()
                    .buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            car = session.get(Car.class, id);
            System.out.println(car);
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
        return car;
    }

    public User getUser(String login) {
        User result = null;
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration()
                    .configure()
                    .buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            Query query= session.createQuery("from User where login=:login");
            query.setParameter("login", login);
            result = (User) query.uniqueResult();
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
        return result;
    }

    public List<Mark> getMarks() {
        List<Mark> result = null;
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration()
                    .configure()
                    .buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            result = session.createQuery("from Mark").list();
            for (Mark mark: result) {
                System.out.println(mark);
            }
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
        return result;
    }

    public List<Model> getModels(int mark_id) {
        List<Model> result = null;
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration()
                    .configure()
                    .buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            /*Query query= session.createQuery("from User where mark_id=:mark_id");
            query.setParameter("mark_id", mark_id);
            result = (List<Model>) query.uniqueResult();
            for (Model model: result) {
                System.out.println(model);
            }*/
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
        return result;
    }
}
