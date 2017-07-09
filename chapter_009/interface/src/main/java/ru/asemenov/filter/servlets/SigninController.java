package ru.asemenov.filter.servlets;

import ru.asemenov.filter.ConnectSql;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SigninController extends HttpServlet {

    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.html").forward(req, resp);
    }*/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        resp.setContentType("text/html");
        if (ConnectSql.getInstance().checkPassword(login, password)) {
            HttpSession session = req.getSession();
            synchronized (session) {
                session.setAttribute("login", login);
                session.setAttribute("role", ConnectSql.getInstance().getRole(login));
            }
        } else {
            PrintWriter out = new PrintWriter(resp.getOutputStream());
            out.append(String.valueOf(false));
            out.flush();
        }
    }
}
