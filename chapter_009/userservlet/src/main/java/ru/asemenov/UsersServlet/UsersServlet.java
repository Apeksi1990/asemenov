package ru.asemenov.UsersServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Class UsersServlet решение задачи части 009.
 * @author asemenov
 * @version 1
 */
public class UsersServlet extends HttpServlet {
    /**
     * ConnectSQL.
     */
    private ConnectSql conn = new ConnectSql();

    /**
     * Get users.
     * @param req HttpServletRequest.
     * @param resp HttpServletResponse.
     * @throws ServletException exception.
     * @throws IOException exception.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        List<User> users = conn.getUset();
        for (User e : users) {
            writer.append(e.toString());
        }
        writer.flush();
    }

    /**
     * Edit users.
     * @param req HttpServletRequest.
     * @param resp HttpServletResponse.
     * @throws ServletException exception.
     * @throws IOException exception.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        conn.editUser(Integer.parseInt(req.getParameter("id")), req.getParameter("name"), req.getParameter("login"), req.getParameter("email"));
    }

    /**
     * Add users.
     * @param req HttpServletRequest.
     * @param resp HttpServletResponse.
     * @throws ServletException exception.
     * @throws IOException exception.
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        conn.addUser(req.getParameter("name"), req.getParameter("login"), req.getParameter("email"));
    }

    /**
     * Delete users.
     * @param req HttpServletRequest.
     * @param resp HttpServletResponse.
     * @throws ServletException exception.
     * @throws IOException exception.
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        conn.deleteUser(Integer.parseInt(req.getParameter("id")));
    }
}
