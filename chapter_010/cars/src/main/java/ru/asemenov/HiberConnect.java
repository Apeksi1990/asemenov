package ru.asemenov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.asemenov.models.*;

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
            Query query= session.createQuery("from Model where mark.id=:mark_id");
            query.setParameter("mark_id", mark_id);
            result = query.list();
            for (Model model: result) {
                System.out.println(model);
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

    public List<Body> getBodies() {
        List<Body> result = null;
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration()
                    .configure()
                    .buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            result = session.createQuery("from Body").list();
            for (Body body: result) {
                System.out.println(body);
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

    public List<Engine> getEngines() {
        List<Engine> result = null;
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration()
                    .configure()
                    .buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            result = session.createQuery("from Engine ").list();
            for (Engine engine: result) {
                System.out.println(engine);
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

    public List<Transmission> getTransmissions() {
        List<Transmission> result = null;
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration()
                    .configure()
                    .buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            result = session.createQuery("from Transmission ").list();
            for (Transmission transmission: result) {
                System.out.println(transmission);
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

    public int addCar(Car car) {
        SessionFactory factory = null;
        Session session = null;
        int id = 0;
        try {
            factory = new Configuration()
                    .configure()
                    .buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            session.save(car);
            id = car.getId();
            System.out.println(id);
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
        return id;
    }

    public void statusOff(int id) {
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration()
                    .configure()
                    .buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            Car car = session.get(Car.class, id);
            car.setStatus(false);
            session.update(car);
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
