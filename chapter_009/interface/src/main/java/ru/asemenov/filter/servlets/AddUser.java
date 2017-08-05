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
        if (session.getAttribute("role").equals("administrator")) {
            ConnectSql.getInstance().addUser(req.getParameter("name"),
                    req.getParameter("login"),
                    req.getParameter("password"),
                    req.getParameter("email"),
                    Integer.parseInt(req.getParameter("role_id")),
                    Integer.parseInt(req.getParameter("city_id"))
            );
        }
    }
}
