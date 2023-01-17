package jm.task.core.jdbc.dao;

import com.mysql.cj.Session;
import jm.task.core.jdbc.model.User;

import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name,lastName,age);
        org.hibernate.Session session = null;
        try {
            Class.forName("com.mysql.cj.Session");
            session = Util.getSessionFactory().openSession();
//            session.beginTransaction();
            session.save(user);
//            session.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
    }


    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
