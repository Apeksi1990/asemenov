package ru.asemenov.JSTL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Class ViewUsers решение задачи части 009.
 * @author asemenov
 * @version 1
 */
public class ViewUsers extends HttpServlet {
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
        req.setAttribute("users", this.connect.getUset());
        req.getRequestDispatcher("/WEB-INF/views/users.jsp").forward(req, resp);
    }
}
