package ru.asemenov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.asemenov.models.*;

import java.util.List;

public class CarStorage {
    private final SessionFactory factory = HibernateFactory.getFactory();

    private static final CarStorage instance = new CarStorage();

    public static CarStorage getInstance() {
        return instance;
    }

    private CarStorage() {
    }

    /**
     * Get all cars.
     * @return List cars.
     */
    public List<Car> getAllCars() {
        List<Car> cars = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            cars = session.createQuery("from Car").list();
            for (Car c: cars) {
                System.out.println(c);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cars;
    }

    /**
     * Get car by id.
     * @param id car.
     * @return Car.
     */
    public Car getCarById(int id) {
        Car car = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            car = session.get(Car.class, id);
            System.out.println(car);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return car;
    }

    /**
     * Get user by login.
     * @param login user.
     * @return USer.
     */
    public User getUser(String login) {
        User result = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Query query= session.createQuery("from User where login=:login");
            query.setParameter("login", login);
            result = (User) query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Gt all mark.
     * @return List mark.
     */
    public List<Mark> getMarks() {
        List<Mark> result = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            result = session.createQuery("from Mark").list();
            for (Mark mark: result) {
                System.out.println(mark);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Get models by mark_id.
     * @param mark_id mark.
     * @return List model.
     */
    public List<Model> getModels(int mark_id) {
        List<Model> result = null;
        try (Session session = factory.openSession()) {
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
        }
        return result;
    }

    /**
     * Get all bodies.
     * @return List bodies.
     */
    public List<Body> getBodies() {
        List<Body> result = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            result = session.createQuery("from Body").list();
            for (Body body: result) {
                System.out.println(body);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Get all engines.
     * @return List engine.
     */
    public List<Engine> getEngines() {
        List<Engine> result = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            result = session.createQuery("from Engine ").list();
            for (Engine engine: result) {
                System.out.println(engine);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Get all transmission.
     * @return List transmission.
     */
    public List<Transmission> getTransmissions() {
        List<Transmission> result = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            result = session.createQuery("from Transmission ").list();
            for (Transmission transmission: result) {
                System.out.println(transmission);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Add new car.
     * @param car Car.
     * @return id new car.
     */
    public int addCar(Car car) {
        int id = 0;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(car);
            id = car.getId();
            System.out.println(id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * Change status car.
     * @param id Car.
     */
    public void statusOff(int id) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Car car = session.get(Car.class, id);
            car.setStatus(false);
            session.update(car);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
