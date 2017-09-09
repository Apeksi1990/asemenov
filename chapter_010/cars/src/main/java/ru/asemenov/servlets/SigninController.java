package ru.asemenov.servlets;

import com.google.gson.Gson;
import ru.asemenov.HiberConnect;
import ru.asemenov.models.User;

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
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login != null) {
            resp.setContentType("text/html");
            User user = HiberConnect.getInstance().getUser(login);
            if (user != null & user.getPassword().equals(password)) {
                HttpSession session = req.getSession();
                synchronized (session) {
                    session.setAttribute("login", user.getLogin());
                    session.setAttribute("id", user.getId());
                }
            } else {
                PrintWriter out = new PrintWriter(resp.getOutputStream());
                out.append(String.valueOf(false));
                out.flush();
            }
        } else {
            HttpSession session = req.getSession();
            User user = HiberConnect.getInstance().getUser(String.valueOf(session.getAttribute("login")));
            String json = new Gson().toJson(user);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
        }

    }
}
