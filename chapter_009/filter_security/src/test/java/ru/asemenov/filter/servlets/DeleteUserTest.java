package ru.asemenov.filter.servlets;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.asemenov.filter.ConnectSql;
import ru.asemenov.filter.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteUserTest {
    @Before
    public void addUser() throws ServletException, IOException {
        AddUser addUser = new AddUser();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("name")).thenReturn("test");
        when(request.getParameter("login")).thenReturn("test");
        when(request.getParameter("password")).thenReturn("test");
        when(request.getParameter("email")).thenReturn("test@mail");
        when(request.getParameter("role_id")).thenReturn("2");

        addUser.doPost(request, response);
    }

    @Test
    public void delete() throws ServletException, IOException {
        DeleteUser deleteUser = new DeleteUser();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("login")).thenReturn("test");
        deleteUser.doPost(request, response);
        List<User> users = ConnectSql.getInstance().getUser();

        Assert.assertEquals(users.size(), 2);
    }
}