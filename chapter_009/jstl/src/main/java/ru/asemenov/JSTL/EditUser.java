package ru.asemenov.JSTL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class EditUser решение задачи части 009.
 * @author asemenov
 * @version 1
 */
public class EditUser extends HttpServlet {
    /**
     * Connect.
     */
    private ConnectSql connect = new ConnectSql();

    /**
     * Initialization.
     * @throws ServletException exception.
     */
    @Override
    public void init() throws ServletException {
        this.connect.openConnection();
    }

    /**
     * Destroy.
     */
    @Override
    public void destroy() {
        this.connect.closeConnection();
    }

    /**
     * Do get.
     * @param req HttpServletRequest.
     * @param resp HttpServletResponse.
     * @throws ServletException exception.
     * @throws IOException exception.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/edituser.jsp").forward(req, resp);
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
        this.connect.editUser(Integer.parseInt(req.getParameter("id")), req.getParameter("name"), req.getParameter("login"), req.getParameter("email"));
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
