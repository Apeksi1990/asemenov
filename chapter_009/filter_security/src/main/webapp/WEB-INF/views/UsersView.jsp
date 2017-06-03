<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
    <table style="border: 1px solid black" cellpadding="5" border="1">
        Вы зашли под пользователем: <c:out value="${login}"></c:out>
        <form action="${pageContext.servletContext.contextPath}/exit" method="post">
        <button type='submit'>Exit</button>
        </form>
        <tr>
            <th>Name</th>
            <th>Login</th>
            <th>E-mail</th>
            <th>Edit</th>
            <c:if test="${role == 'administrator'}">
                <th>Delete</th>
            </c:if>
        </tr>
        <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.login}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><form action="${pageContext.servletContext.contextPath}/edit">
                <input type='hidden' name = 'name'   value='<c:out value="${user.name}"></c:out>'/>
                <input type='hidden' name = 'login'   value='<c:out value="${user.login}"></c:out>'/>
                <input type='hidden' name = 'email'   value='<c:out value="${user.email}"></c:out>'/>
                <c:choose>
                    <c:when test="${role == 'administrator'}">
                        <button type='submit'>Edit</button>
                    </c:when>
                    <c:when test="${role == 'user'}">
                        <button type='submit'<c:if test="${user.login != login}">disabled = 'true'</c:if>>Edit</button>
                    </c:when>
                </c:choose>
            </form> </td>
            <c:if test="${role == 'administrator'}">
                <td><form action="${pageContext.servletContext.contextPath}/delete">
                    <input type='hidden' name = 'name'   value='<c:out value="${user.name}"></c:out>'/>
                    <input type='hidden' name = 'login'   value='<c:out value="${user.login}"></c:out>'/>
                    <input type='hidden' name = 'email'   value='<c:out value="${user.email}"></c:out>'/>
                    <button type='submit'>Delete</button>
                </form> </td>
            </c:if>
        </tr>
        </c:forEach>
    </table>
    <br/>
    <c:if test="${role == 'administrator'}">
        <a href = "${pageContext.servletContext.contextPath}/add">Add user</a>
    </c:if>
</body>
</html>
