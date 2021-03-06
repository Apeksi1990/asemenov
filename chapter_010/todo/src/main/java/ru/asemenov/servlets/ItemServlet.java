package ru.asemenov.servlets;

import com.google.gson.Gson;
import ru.asemenov.HiberConnect;
import ru.asemenov.models.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> items = HiberConnect.getInstance().getAllItem();
        String json = new Gson().toJson(items);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HiberConnect connect = HiberConnect.getInstance();
        if (req.getParameter("id") != null) {
            connect.editState(Integer.parseInt(req.getParameter("id")), Boolean.parseBoolean(req.getParameter("state")));
        } else {
            connect.addItem(req.getParameter("text"));
        }
    }
}
