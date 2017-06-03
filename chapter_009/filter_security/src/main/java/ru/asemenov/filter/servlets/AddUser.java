package ru.asemenov.filter.servlets;

import ru.asemenov.filter.ConnectSql;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class AddUser решение задачи части 009.
 * @author asemenov
 * @version 1
 */
public class AddUser extends HttpServlet {

    /**
     * Do get.
     * @param req HttpServletRequest.
     * @param resp HttpServletResponse.
     * @throws ServletException exception.
     * @throws IOException exception.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (!session.getAttribute("role").equals("administrator")) {
            resp.sendRedirect(String.format("%s/", req.getContextPath()));
        } else {
            req.getRequestDispatcher("/WEB-INF/views/AddUser.jsp").forward(req, resp);
        }
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
        ConnectSql.getInstance().addUser(req.getParameter("name"),
                req.getParameter("login"),
                req.getParameter("password"),
                req.getParameter("email"),
                Integer.parseInt(req.getParameter("role_id")));
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
