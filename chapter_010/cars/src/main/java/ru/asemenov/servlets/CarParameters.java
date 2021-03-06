package ru.asemenov.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.asemenov.CarStorage;
import ru.asemenov.models.*;
import ru.asemenov.servlets.adapters.HibernateProxyTypeAdapter;
import ru.asemenov.servlets.adapters.MarkAdapter;
import ru.asemenov.servlets.adapters.ModelAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class CarParameters extends HttpServlet{

    private final String path = "C:\\test";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = "";
        GsonBuilder b = new GsonBuilder();
        b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = b.create();
        String type = req.getParameter("type");

        switch (type) {
            case "mark":
                b.registerTypeAdapter(Model.class, new ModelAdapter());
                gson = b.registerTypeAdapter(Mark.class, new MarkAdapter()).create();
                List<Mark> mark = CarStorage.getInstance().getMarks();
                json = gson.toJson(mark);
                break;
            case "model":
                gson = b.registerTypeAdapter(Model.class, new ModelAdapter()).create();
                List<Model> model = CarStorage.getInstance().getModels(Integer.parseInt(req.getParameter("mark")));
                json = gson.toJson(model);
                break;
            case "body":
                List<Body> body = CarStorage.getInstance().getBodies();
                json = gson.toJson(body);
                break;
            case "engine":
                List<Engine> engine = CarStorage.getInstance().getEngines();
                json = gson.toJson(engine);
                break;
            case "transmission":
                List<Transmission> transmission = CarStorage.getInstance().getTransmissions();
                json = gson.toJson(transmission);
                break;
            case "img":
                int id = Integer.parseInt(req.getParameter("id"));
                json = img(id);
                System.out.println("File name:");
                System.out.println(json);
                break;
        }
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Car car = CarStorage.getInstance().getCarById(Integer.parseInt(req.getParameter("id")));
        HttpSession session = req.getSession();
        int idSessionUser = (int) session.getAttribute("id");
        if (car.getUser().getId() == idSessionUser) {
            CarStorage.getInstance().statusOff(car.getId());
        }
    }

    private String img(int id) {
        File[]fList;
        File F = new File(path + File.separator + id);
        fList = F.listFiles();
        return fList[0].getName();
    }
}
