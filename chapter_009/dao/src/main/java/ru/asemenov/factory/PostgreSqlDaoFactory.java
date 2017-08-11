package ru.asemenov.factory;

import org.apache.commons.dbcp2.BasicDataSource;
import ru.asemenov.daoInterface.AddressDAO;
import ru.asemenov.daoInterface.MusicTypeDAO;
import ru.asemenov.daoInterface.RoleDAO;
import ru.asemenov.daoInterface.UserDAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class PostgreSqlDaoFactory implements DAOFactory {

    private BasicDataSource ds;

    private static PostgreSqlDaoFactory ourInstance = new PostgreSqlDaoFactory();

    static PostgreSqlDaoFactory getInstance() {
        return ourInstance;
    }

    private PostgreSqlDaoFactory() {
        setDataSoure();
    }

    private void setDataSoure() {
        Properties props = new Properties();
        InputStream inputStream;
        this.ds = new BasicDataSource();
        ClassLoader loader = getClass().getClassLoader();
        try {
            inputStream = loader.getResourceAsStream("db.properties");
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.ds.setDriverClassName(props.getProperty("DRIVER"));
        this.ds.setUrl(props.getProperty("URL"));
        this.ds.setUsername(props.getProperty("USERNAME"));
        this.ds.setPassword(props.getProperty("PASSWORD"));
    }

    @Override
    public Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }

    @Override
    public AddressDAO getAddressDao() {
        return new PostgreSqlAddressDao(this);
    }

    @Override
    public MusicTypeDAO getMusicTypeDao() {
        return new PostgreSqlMusicTypeDao(this);
    }

    @Override
    public RoleDAO getRoleDao() {
        return new PostgreSqlRoleDao(this);
    }

    @Override
    public UserDAO getUserDao() {
        return new PostgreSqlUserDao(this);
    }
}
