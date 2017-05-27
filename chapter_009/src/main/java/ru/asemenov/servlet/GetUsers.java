package ru.asemenov.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
/**
 * Class GetUsers решение задачи части 009.
 * @author asemenov
 * @version 1
 */
public class GetUsers extends HttpServlet {
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
        List<User> users = connect.getUset();

        writer.append("<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "    <meta charset=\"UTF-8\">"
                + "    <title>All user</title>"
                + "</head>"
                + "<body>"
                + "<table border = '1' cellpadding = '5'>"
                + "<tr>"
                + "<th>Name</th>"
                + "<th>Login</th>"
                + "<th>E-mail</th>"
                + "<th>Edit</th>"
                + "<th>Delete</th>"
                + "</tr>"
        );
        for (User user : users) {
            String edit = String.format("%s/editusersservlet", req.getContextPath());
            String delete = String.format("%s/deleteusersservlet", req.getContextPath());
            String id = String.format("<input type='hidden' name = 'id'   value='%s'/>", user.getId());
            String name = String.format("<input type='hidden' name = 'name'   value='%s'/>", user.getName());
            String login = String.format("<input type='hidden' name = 'login'   value='%s'/>", user.getLogin());
            String email = String.format("<input type='hidden' name = 'email'   value='%s'/>", user.getEmail());
            writer.append("<tr>"
                    + "<td>" + user.getName() + "</td>"
                    + "<td>" + user.getLogin() + "</td>"
                    + "<td>" + user.getEmail() + "</td>"
                    + "<td><form action = '" + edit + "'>" + id + name + login + email
                    + "<button type='submit'>Edit</button></form></td>"
                    + "<td><form action = '" + delete + "'>" + id + name + login + email
                    + "<button type='submit'>Delete</button></form></td>"
                    + "</tr>");
        }
        writer.append("</table>"
                + "<br/>"
                + "<a href = '" + String.format("%s/addusersservlet", req.getContextPath()) + "'>Add user</a>"
                + "</body>"
                + "</html>");
        writer.flush();
    }
}
