package ru.asemenov.filter.servlets;

import ru.asemenov.filter.ConnectSql;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class DeleteUser решение задачи части 009.
 * @author asemenov
 * @version 1
 */
public class DeleteUser extends HttpServlet {
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
        ConnectSql.getInstance().deleteUser(req.getParameter("login"));
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
