package ru.asemenov.filter.servlets;

import com.google.gson.Gson;
import ru.asemenov.filter.ConnectSql;
import ru.asemenov.filter.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Class SigninController решение задачи части 009.
 * @author asemenov
 * @version 1
 */
public class SigninController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        User user;
        HttpSession session = req.getSession();
        synchronized (session) {
            user = ConnectSql.getInstance().getUser((String) session.getAttribute("login"));
        }
        String json = new Gson().toJson(user);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        resp.setContentType("text/html");
        if (ConnectSql.getInstance().checkPassword(login, password)) {
            HttpSession session = req.getSession();
            synchronized (session) {
                session.setAttribute("login", login);
                session.setAttribute("role", ConnectSql.getInstance().getUser(login).getRole().getName());
            }
        } else {
            PrintWriter out = new PrintWriter(resp.getOutputStream());
            out.append(String.valueOf(false));
            out.flush();
        }
    }
}
