package ru.asemenov.echo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class UsersController решение задачи части 009.
 * @author asemenov
 * @version 1
 */
public class UsersController extends HttpServlet {
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
        synchronized (session) {
            if (session == null || session.getAttribute("login") == null) {
                resp.sendRedirect(String.format("%s/signin", req.getContextPath()));
            } else {
                req.setAttribute("users", UserStorage.getInstance().getUsers());
                req.getRequestDispatcher("/WEB-INF/views/UsersView.jsp").forward(req, resp);
            }
        }
    }

    /**
     * Do post.
     * @param req HttpServletRequest.
     * @param resp HttpServletResponse.
     * @throws ServletException exception.
     * @throws IOException exception.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        UserStorage.getInstance().add(new User(req.getParameter("login"), req.getParameter("email"), null));
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
