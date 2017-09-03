package ru.asemenov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import ru.asemenov.models.*;

import java.util.List;

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

            Body body = session.get(Body.class, 1);
            Engine engine = session.get(Engine.class, 1);
            Mark mark = session.get(Mark.class, 1);
            Model model = session.get(Model.class, 1);
            Transmission transmission = session.get(Transmission.class, 1);
            Car car = session.get(Car.class, 1);

            /*System.out.println(body);
            System.out.println(engine);
            System.out.println(mark);
            System.out.println(model);
            System.out.println(transmission);*/
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

    @Test
    public void testGetCars() {
        List<Car> cars = HiberConnect.getInstance().getAllCars();
        for (Car car : cars) {
            System.out.println(car.getMark());
        }
    }
}
