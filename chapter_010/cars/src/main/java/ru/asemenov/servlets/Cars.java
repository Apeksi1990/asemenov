package ru.asemenov.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.asemenov.HiberConnect;
import ru.asemenov.models.*;
import ru.asemenov.servlets.adapters.CarsAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Cars extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json;
        GsonBuilder b = new GsonBuilder();
        Gson gson = b.registerTypeAdapter(Car.class, new CarsAdapter()).create();
        if (req.getParameter("id") != null) {
            Car car = HiberConnect.getInstance().getCarById(Integer.parseInt(req.getParameter("id")));
            json = gson.toJson(car);
        } else {
            List<Car> cars = HiberConnect.getInstance().getAllCars();
            json = gson.toJson(cars);
        }
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        Car car = new Car();
        car.setMark(new Mark(Integer.parseInt(req.getParameter("mark"))));
        car.setModel(new Model(Integer.parseInt(req.getParameter("model"))));
        car.setBody(new Body(Integer.parseInt(req.getParameter("body"))));
        car.setYear(Integer.parseInt(req.getParameter("year")));
        car.setDistance(Integer.parseInt(req.getParameter("distance")));
        car.setTransmission(new Transmission(Integer.parseInt(req.getParameter("transmission"))));
        car.setEngine(new Engine(Integer.parseInt(req.getParameter("engine"))));
        car.setCapacity(Integer.parseInt(req.getParameter("capacity")));
        car.setPrice(Integer.parseInt(req.getParameter("price")));
        car.setUser(new User(Integer.parseInt(String.valueOf(session.getAttribute("id")))));
        car.setStatus(true);
        int id = HiberConnect.getInstance().addCar(car);
        PrintWriter out = new PrintWriter(resp.getOutputStream());
        out.append(String.valueOf(id));
        out.flush();
    }
}
