<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
    <form action="${pageContext.servletContext.contextPath}/add" method="post">
        Add user:
        <br/>
        Name: <input type = 'text' name = 'name'/>
        <br/>
        Login: <input type = 'text' name = 'login'/>
        <br/>
        Password: <input type = 'password' name = 'password'/>
        <br/>
        E-mail: <input type = 'text' name = 'email'/>
        <br/>
        Role ID: <input type = 'text' name = 'role_id'/>
        <br/>
        <input type = 'submit' value = 'Add user'>
    </form>
    <br/>
    <a href="${pageContext.servletContext.contextPath}/">Back to all user</a>
</body>
</html>
