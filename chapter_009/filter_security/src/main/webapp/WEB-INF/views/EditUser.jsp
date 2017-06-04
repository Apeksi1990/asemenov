<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
    Edit user:
    <br/>
    <form action="${pageContext.servletContext.contextPath}/edit" method="post">
        <input type='hidden' name = 'id'   value='<c:out value="${param.id}"></c:out>'/>
        Name: <input type='text' name = 'name'   value='<c:out value="${param.name}"></c:out>'/>
        <br/>
        Login: <input type='text' name = 'login'   value='<c:out value="${param.login}"></c:out>'/>
        <br/>
        E-mail: <input type='text' name = 'email'   value='<c:out value="${param.email}"></c:out>'/>
        <br/>
        <c:if test="${role == 'administrator'}">
            <select name = 'role_id'>
                <c:forEach items="${roles}" var="entry">
                    <option value="${entry.key}"<c:if test="${param.role == entry.value}">selected</c:if>>${entry.value}</option>
                </c:forEach>
            </select>
        </c:if>
        <br/>
        <input type = 'submit' value = 'Edit user'>
    </form>
    <br/>
    <a href="${pageContext.servletContext.contextPath}/">Back to all user</a>
</body>
</html>
