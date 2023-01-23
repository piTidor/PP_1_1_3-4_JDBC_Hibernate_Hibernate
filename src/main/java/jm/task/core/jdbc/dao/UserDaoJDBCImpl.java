package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = "CREATE TABLE `example`.`user` (\n" +
                "  `id` BIGINT(30) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NOT NULL,\n" +
                "  `lastname` VARCHAR(45) NOT NULL,\n" +
                "  `age` INTEGER(3) NOT NULL,\n" +
                "  PRIMARY KEY (`id`));";
        try (PreparedStatement prepareStatement = Util.getMyConnection().prepareStatement(sql)){

            prepareStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS user";
        try (PreparedStatement prepareStatement = Util.getMyConnection().prepareStatement(sql)){
        prepareStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO user(name,lastname,age) VALUES(?,?,?)";
        try (PreparedStatement prepareStatement = Util.getMyConnection().prepareStatement(sql)){
            prepareStatement.setString(1, name);
            prepareStatement.setString(2, lastName);
            prepareStatement.setInt(3, age);
            prepareStatement.execute();
            System.out.println("User с именем  – "+ name +" добавлен в базу данных");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM user where id =" + id;
        try (PreparedStatement prepareStatement = Util.getMyConnection().prepareStatement(sql)){
            prepareStatement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public List<User> getAllUsers() {
        String sql = "select * from user";
        try {
            PreparedStatement prepareStatement = Util.getMyConnection().prepareStatement(sql);

            ResultSet rs = prepareStatement.executeQuery();
            List<User> li = new ArrayList<>();
            int i =0;
                while (rs.next()){
                    User user = new User();
                    user.setId(rs.getLong(1));
                    user.setName(rs.getString(2));
                    user.setLastName(rs.getString(3));
                    user.setAge((byte) rs.getInt(4));
                    li.add(i,user);
                    i++; }
            return li;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void cleanUsersTable() {
        String sql = "DELETE FROM user;";
        try (PreparedStatement prepareStatement = Util.getMyConnection().prepareStatement(sql)){
            prepareStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
