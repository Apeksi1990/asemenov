<%@ page import="ru.asemenov.JSP.User" %>
<%@ page import="ru.asemenov.JSP.ConnectSql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
    <table style="border: 1px solid black" cellpadding="5" border="1">
        <tr>
            <th>Name</th>
            <th>Login</th>
            <th>E-mail</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <%for (User user: ConnectSql.getInstance().getUset()) { %>
        <tr>
            <td><%=user.getName()%></td>
            <td><%=user.getLogin()%></td>
            <td><%=user.getEmail()%></td>
            <td><form action="<%=request.getContextPath()%>/edituser.jsp">
                <input type='hidden' name = 'id'   value='<%=user.getId()%>'/>
                <input type='hidden' name = 'name'   value='<%=user.getName()%>'/>
                <input type='hidden' name = 'login'   value='<%=user.getLogin()%>'/>
                <input type='hidden' name = 'email'   value='<%=user.getEmail()%>'/>
                <button type='submit'>Edit</button>
            </form> </td>
            <td><form action="<%=request.getContextPath()%>/deleteuser.jsp">
                <input type='hidden' name = 'id'   value='<%=user.getId()%>'/>
                <input type='hidden' name = 'name'   value='<%=user.getName()%>'/>
                <input type='hidden' name = 'login'   value='<%=user.getLogin()%>'/>
                <input type='hidden' name = 'email'   value='<%=user.getEmail()%>'/>
                <button type='submit'>Delete</button>
            </form> </td>
        </tr>
        <% } %>
    </table>
    <br/>
    <a href = "<%=request.getContextPath()%>/adduser.jsp">Add user</a>
</body>
</html>
