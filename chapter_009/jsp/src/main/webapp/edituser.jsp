<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
    Edit user:
    <br/>
    <form action="<%=request.getContextPath()%>/edituserjsp" method="post">
        <input type='hidden' name = 'id'   value='<%=request.getParameter("id")%>'/>
        Name: <input type='text' name = 'name'   value='<%=request.getParameter("name")%>'/>
        <br/>
        Login: <input type='text' name = 'login'   value='<%=request.getParameter("login")%>'/>
        <br/>
        E-mail: <input type='text' name = 'email'   value='<%=request.getParameter("email")%>'/>
        <br/>
        <input type = 'submit' value = 'Edit user'>
    </form>
    <br/>
    <a href="<%=request.getContextPath()%>/users.jsp">Back to all user</a>
</body>
</html>
