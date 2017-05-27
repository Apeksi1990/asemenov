package ru.asemenov.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Class EditUser решение задачи части 009.
 * @author asemenov
 * @version 1
 */
public class EditUser extends HttpServlet {
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
        String id = String.format("<input type='hidden' name = 'id'   value='%s'/>", req.getParameter("id"));
        String name = String.format("<input type='text' name = 'name'   value='%s'/>", req.getParameter("name"));
        String login = String.format("<input type='text' name = 'login'   value='%s'/>", req.getParameter("login"));
        String email = String.format("<input type='text' name = 'email'   value='%s'/>", req.getParameter("email"));
        writer.append("<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "    <meta charset=\"UTF-8\">"
                + "    <title>Edit user user</title>"
                + "</head>"
                + "<body>"
                + "Edit user:"
                + "<br/>"
                + "<form action = '" + req.getContextPath() + "/editusersservlet' method = 'post'>"
                + id
                + "Name: " + name
                + "<br/>"
                + "Login: " + login
                + "<br/>"
                + "E-mail: " + email
                + "<br/>"
                + "<input type = 'submit' value = 'Edit user'>"
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
        this.connect.editUser(Integer.parseInt(req.getParameter("id")), req.getParameter("name"), req.getParameter("login"), req.getParameter("email"));
        resp.sendRedirect(String.format("%s/getusersservlet", req.getContextPath()));
    }
}
