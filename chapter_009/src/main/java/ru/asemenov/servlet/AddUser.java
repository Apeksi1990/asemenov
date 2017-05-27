package ru.asemenov.servlet;

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
     * Connection sql.
     */
    private ConnectSql connect = new ConnectSql();

    /**
     * Init.
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
     * Get.
     * @param req HttpServletRequest.
     * @param resp HttpServletResponse.
     * @throws ServletException exception.
     * @throws IOException exception.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());

        writer.append("<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "    <meta charset=\"UTF-8\">"
                + "    <title>Add user</title>"
                + "</head>"
                + "<body>"
                + "<form action = '" + req.getContextPath() + "/addusersservlet' method = 'post'>"
                + "Name: <input type = 'text' name = 'name'/>"
                + "<br/>"
                + "Login: <input type = 'text' name = 'login'/>"
                + "<br/>"
                + "E-mail: <input type = 'text' name = 'email'/>"
                + "<br/>"
                + "<input type = 'submit' value = 'Add user'>"
                + "</form>"
                + "<br/>"
                + "<a href = '" + req.getContextPath() + "/getusersservlet'>Back to all user</a>"
                + "</body>"
                + "</html>"
        );
        writer.flush();
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
        this.connect.addUser(req.getParameter("name"), req.getParameter("login"), req.getParameter("email"));
        resp.sendRedirect(String.format("%s/getusersservlet", req.getContextPath()));
    }
}
