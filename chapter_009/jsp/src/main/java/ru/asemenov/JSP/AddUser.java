package ru.asemenov.JSP;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class AddUser решение задачи части 009.
 * @author asemenov
 * @version 1
 */
public class AddUser extends HttpServlet {

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
        ConnectSql.getInstance().addUser(req.getParameter("name"), req.getParameter("login"), req.getParameter("email"));
        resp.sendRedirect(String.format("%s/users.jsp", req.getContextPath()));
    }
}
