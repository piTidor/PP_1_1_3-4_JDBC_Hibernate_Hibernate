package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UserServiceImpl us = new UserServiceImpl();

        us.dropUsersTable();
        us.createUsersTable();
        us.saveUser("Marina","Zernina", (byte) 23);
        us.saveUser("Valera","Eremin", (byte) 17);
        us.saveUser("Margarita","Simonian", (byte) 56);
        us.saveUser("Vladimir","Kiryakov", (byte) 24);
        Iterator<User> it = us.getAllUsers().iterator();
        while (it.hasNext()){
            User u = it.next();
            System.out.println(u);
        }
//        us.cleanUsersTable();
        us.dropUsersTable();

    }
}
