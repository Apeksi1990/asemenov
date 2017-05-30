<%--
  Created by IntelliJ IDEA.
  User: Semenov_am
  Date: 29.05.2017
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete user</title>
</head>
<body>
    Delete this user?
    <br/>
    <form action="<%=request.getContextPath()%>/deleteuserjsp" method="post">
        ID: <%=request.getParameter("id")%>
        <br/>
        Name: <%=request.getParameter("name")%>
        <br/>
        Login: <%=request.getParameter("login")%>
        <br/>
        E-mail: <%=request.getParameter("email")%>
        <br/>
        <input type='hidden' name = 'id'   value='<%=request.getParameter("id")%>'/>
        <input type = 'submit' value = 'Delete user'>
    </form>
    <br/>
    <a href="<%=request.getContextPath()%>/users.jsp">Back to all user</a>
</body>
</html>
