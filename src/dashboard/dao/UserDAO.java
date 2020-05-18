package dashboard.dao;

import common.Jdbc;
import dashboard.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDAO implements  IUserDAO{

    public UserDAO(){
    }

    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(Jdbc.JDBC_DRIVER);
        } catch ()
    }

    @Override
    public void insertUser(User user) throws SQLException {

    }

    @Override
    public User selectUser(int id) {
        return null;
    }

    @Override
    public List<User> selectAllUsers() {
        return null;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return false;
    }
}
