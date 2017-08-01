package ru.asemenov.filter.servlets;

import com.google.gson.Gson;
import ru.asemenov.filter.ConnectSql;
import ru.asemenov.filter.models.City;
import ru.asemenov.filter.models.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Class EditUser решение задачи части 009.
 * @author asemenov
 * @version 1
 */
public class EditUser extends HttpServlet {
    /**
     * Get roles.
     * @param req HttpServletRequest.
     * @param resp HttpServletResponse.
     * @throws ServletException exception.
     * @throws IOException exception.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String json = "";
        if (req.getParameter("option").equals("roles")) {
            List<Role> roles;
            HttpSession session = req.getSession();
            synchronized (session) {
                roles = ConnectSql.getInstance().getRoles();
            }
            json = new Gson().toJson(roles);
        } else if (req.getParameter("option").equals("countries")) {
            List<String> countries;
            HttpSession session = req.getSession();
            synchronized (session) {
                countries = ConnectSql.getInstance().getCountries();
            }
            json = new Gson().toJson(countries);
        } else if (req.getParameter("option").equals("city")) {
            List<City> countries;
            HttpSession session = req.getSession();
            synchronized (session) {
                countries = ConnectSql.getInstance().getCities(req.getParameter("country"));
            }
            json = new Gson().toJson(countries);
        }
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    /**
     * Post.
     * @param req HttpServletRequest.
     * @param resp HttpServletResponse.
     * @throws ServletException exception.
     * @throws IOException exception.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        if (!session.getAttribute("role").equals("administrator")) {
            ConnectSql.getInstance().editUser(String.valueOf(session.getAttribute("login")), req.getParameter("name"), req.getParameter("login"), req.getParameter("email"));
        } else {
            ConnectSql.getInstance().editUser(req.getParameter("oldLogin"), req.getParameter("name"), req.getParameter("login"), req.getParameter("email"));
            ConnectSql.getInstance().setRole(req.getParameter("login"), Integer.parseInt(req.getParameter("role_id")));
            ConnectSql.getInstance().setCity(req.getParameter("login"), Integer.parseInt(req.getParameter("city_id")));
        }
    }
}
