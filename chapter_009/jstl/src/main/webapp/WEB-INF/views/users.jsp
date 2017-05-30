<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.login}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><form action="${pageContext.servletContext.contextPath}/edit">
                <input type='hidden' name = 'id'   value='<c:out value="${user.id}"></c:out>'/>
                <input type='hidden' name = 'name'   value='<c:out value="${user.name}"></c:out>'/>
                <input type='hidden' name = 'login'   value='<c:out value="${user.login}"></c:out>'/>
                <input type='hidden' name = 'email'   value='<c:out value="${user.email}"></c:out>'/>
                <button type='submit'>Edit</button>
            </form> </td>
            <td><form action="${pageContext.servletContext.contextPath}/delete">
                <input type='hidden' name = 'id'   value='<c:out value="${user.id}"></c:out>'/>
                <input type='hidden' name = 'name'   value='<c:out value="${user.name}"></c:out>'/>
                <input type='hidden' name = 'login'   value='<c:out value="${user.login}"></c:out>'/>
                <input type='hidden' name = 'email'   value='<c:out value="${user.email}"></c:out>'/>
                <button type='submit'>Delete</button>
            </form> </td>
        </tr>
        </c:forEach>
    </table>
    <br/>
    <a href = "${pageContext.servletContext.contextPath}/add">Add user</a>
</body>
</html>
