package ru.asemenov.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.asemenov.HiberConnect;
import ru.asemenov.models.Car;
import ru.asemenov.servlets.adapters.CarsAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        super.doPost(req, resp);
    }
}
