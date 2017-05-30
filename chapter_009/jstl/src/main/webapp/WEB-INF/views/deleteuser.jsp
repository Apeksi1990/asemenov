<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Delete user</title>
</head>
<body>
    Delete this user?
    <br/>
    <form action="${pageContext.servletContext.contextPath}/delete" method="post">
        ID: <c:out value="${param.id}"></c:out>
        <br/>
        Name: <c:out value="${param.name}"></c:out>
        <br/>
        Login: <c:out value="${param.login}"></c:out>
        <br/>
        E-mail: <c:out value="${param.email}"></c:out>
        <br/>
        <input type='hidden' name = 'id'   value='<c:out value="${param.id}"></c:out>'/>
        <input type = 'submit' value = 'Delete user'>
    </form>
    <br/>
    <a href="${pageContext.servletContext.contextPath}/">Back to all user</a>
</body>
</html>
