package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDaoJDBCImpl us = new UserDaoJDBCImpl();
    public void createUsersTable() {
        us.createUsersTable();
    }

    public void dropUsersTable() throws SQLException, ClassNotFoundException {
        us.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException, ClassNotFoundException {
        us.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) {
    us.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return us.getAllUsers();
    }

    public void cleanUsersTable() {
    us.cleanUsersTable();
    }
}
