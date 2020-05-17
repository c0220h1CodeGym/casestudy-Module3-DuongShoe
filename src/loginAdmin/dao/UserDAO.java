package loginAdmin.dao;

import common.Error;
import common.Jdbc;
import loginAdmin.model.User;

import java.sql.*;

public class UserDAO implements IUserDAO {

    public UserDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(Jdbc.JDBC_DRIVER);
            connection = DriverManager.getConnection(Jdbc.DATABASE_URL, Jdbc.USER, Jdbc.PASSWORD);
        } catch (SQLException ex) {
            System.err.println(Error.ERROR_001);
        } catch (ClassNotFoundException ex) {
            System.err.println(Error.ERROR_002);
        }
        return connection;
    }

    @Override
    public User selectAdmin() {
        User admin = null;
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String username;
        String password;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(Jdbc.SELECT_ADMIN_FROM_USER);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                username = resultSet.getString("username");
                password = resultSet.getString("password");
                admin = new User(username, password);
            }
        } catch (SQLException e) {
            System.err.println(Error.ERROR_003);
        }
        return admin;
    }
}