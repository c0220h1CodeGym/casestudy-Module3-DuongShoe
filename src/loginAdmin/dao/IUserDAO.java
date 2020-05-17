package loginAdmin.dao;

import loginAdmin.model.User;

import java.sql.SQLException;

public interface IUserDAO {
    public User selectAdmin() throws SQLException;
}