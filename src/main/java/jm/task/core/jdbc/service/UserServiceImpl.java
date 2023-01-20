package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

    public class UserServiceImpl implements UserService {

    private UserDaoJDBCImpl us = new UserDaoJDBCImpl();
    private UserDaoHibernateImpl uss = new UserDaoHibernateImpl();
    public void createUsersTable() {
        uss.createUsersTable();
    }

    public void dropUsersTable() throws SQLException, ClassNotFoundException {
        uss.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException, ClassNotFoundException {
        uss.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) {
    uss.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return uss.getAllUsers();
    }

    public void cleanUsersTable() {
    uss.cleanUsersTable();
    }
}
