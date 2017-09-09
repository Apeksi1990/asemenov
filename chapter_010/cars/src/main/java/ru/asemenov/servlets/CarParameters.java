package ru.asemenov.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.asemenov.HiberConnect;
import ru.asemenov.models.Mark;
import ru.asemenov.models.Model;
import ru.asemenov.servlets.adapters.MarkAdapter;
import ru.asemenov.servlets.adapters.ModelAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CarParameters extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = "";
        GsonBuilder b = new GsonBuilder();
        b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = b.create();
        String type = req.getParameter("type");

        if (type.equals("mark")) {
            b.registerTypeAdapter(Model.class, new ModelAdapter());
            gson = b.registerTypeAdapter(Mark.class, new MarkAdapter()).create();
            List<Mark> mark = HiberConnect.getInstance().getMarks();
            json = gson.toJson(mark);
        } else if (type.equals("model")) {
            gson = b.registerTypeAdapter(Model.class, new ModelAdapter()).create();
            List<Model> model = HiberConnect.getInstance().getModels(Integer.parseInt(req.getParameter("mark")));
            json = gson.toJson(model);
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
