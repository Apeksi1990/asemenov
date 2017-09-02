package ru.asemenov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import ru.asemenov.models.Car;

public class testConnect {
    @Test
    public void test() {
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration()
                    .configure()
                    .buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();

            Car car = session.get(Car.class, 1);
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
    }
}
