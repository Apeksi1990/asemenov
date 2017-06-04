package ru.asemenov.filter.servlets;

import ru.asemenov.filter.ConnectSql;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class EditUser решение задачи части 009.
 * @author asemenov
 * @version 1
 */
public class EditUser extends HttpServlet {

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
        if (session.getAttribute("role").equals("administrator")) {
            req.setAttribute("roles", ConnectSql.getInstance().getRoles());
        }
        req.getRequestDispatcher("/WEB-INF/views/EditUser.jsp").forward(req, resp);
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
            ConnectSql.getInstance().editUser(req.getParameter("name"), String.valueOf(session.getAttribute("login")), req.getParameter("email"));
        } else {
            ConnectSql.getInstance().editUser(req.getParameter("name"), req.getParameter("login"), req.getParameter("email"));
            ConnectSql.getInstance().setRole(req.getParameter("login"), Integer.parseInt(req.getParameter("role_id")));
        }
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
