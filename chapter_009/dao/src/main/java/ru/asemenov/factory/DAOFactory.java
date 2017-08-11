package ru.asemenov.factory;

import ru.asemenov.daoInterface.AddressDAO;
import ru.asemenov.daoInterface.MusicTypeDAO;
import ru.asemenov.daoInterface.RoleDAO;
import ru.asemenov.daoInterface.UserDAO;

import java.sql.Connection;
import java.sql.SQLException;

public interface DAOFactory {
    Connection getConnection() throws SQLException;
    AddressDAO getAddressDao();
    MusicTypeDAO getMusicTypeDao();
    RoleDAO getRoleDao();
    UserDAO getUserDao();
}
