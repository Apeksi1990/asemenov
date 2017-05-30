<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/adduserjsp" method="post">
        Add user:
        <br/>
        Name: <input type = 'text' name = 'name'/>
        <br/>
        Login: <input type = 'text' name = 'login'/>
        <br/>
        E-mail: <input type = 'text' name = 'email'/>
        <br/>
        <input type = 'submit' value = 'Add user'>
    </form>
    <br/>
    <a href="<%=request.getContextPath()%>/users.jsp">Back to all user</a>
</body>
</html>
