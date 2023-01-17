package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        Connection conn = Util.getMySQLConnection();

//        System.out.println("Get connection " + conn);

//        Statement statement = conn.createStatement();
//        String sql = "INSERT INTO users(name,age,email) VALUES ('Max', 15 , 'max@mail.com');";
//        String delete = "DELETE FROM users";
        UserServiceImpl us = new UserServiceImpl();

        us.dropUsersTable();
        us.createUsersTable();
//        us.createUsersTable();
        us.saveUser("Marina","Zernina", (byte) 23);
//        System.out.println("User с именем  – Marina добавлен в базу данных");
        us.saveUser("Valera","Eremin", (byte) 17);
//        System.out.println("User с именем  – Valera добавлен в базу данных");
        us.saveUser("Margarita","Simonian", (byte) 56);
//        System.out.println("User с именем  – Margarita добавлен в базу данных");
        us.saveUser("Vladimir","Kiryakov", (byte) 24);
//        System.out.println("User с именем  – Vladimir добавлен в базу данных");
        Iterator<User> it = us.getAllUsers().iterator();
        while (it.hasNext()){
            User u = it.next();
            System.out.println(u);
        }
        us.cleanUsersTable();
        us.dropUsersTable();

    }
}
