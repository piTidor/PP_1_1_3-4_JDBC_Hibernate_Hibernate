package jm.task.core.jdbc.dao;

import com.mysql.cj.Session;
import jm.task.core.jdbc.model.User;

import jm.task.core.jdbc.util.Util;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try (org.hibernate.Session session = Util.getSessionFactory().openSession()){

            session.beginTransaction();
            session.createSQLQuery("CREATE TABLE `example`.`user` (\n" +
                    "  `id` BIGINT(30) NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NOT NULL,\n" +
                    "  `lastname` VARCHAR(45) NOT NULL,\n" +
                    "  `age` INTEGER(3) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`));").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {

        }


    }

    @Override
    public void dropUsersTable() {
        try (org.hibernate.Session session = Util.getSessionFactory().openSession()){

            session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS user").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {

        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name,lastName,age);
        try (org.hibernate.Session session = Util.getSessionFactory().openSession()){

            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            System.out.println("User с именем  – "+ name +" добавлен в базу данных");
        } catch (Exception e) {
        }

    }


    @Override
    public void removeUserById(long id) {
        try (org.hibernate.Session session = Util.getSessionFactory().openSession()){

            session.beginTransaction();
            session.remove(id);
            session.getTransaction().commit();
        } catch (Exception e) {
        }

    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = null;
        try (org.hibernate.Session session = Util.getSessionFactory().openSession()) {

            session.beginTransaction();

            Criteria criteria;
            criteria = session.createCriteria(User.class);
            users = criteria.list();
//
//            for (Iterator<User> it = users.iterator(); it.hasNext(); ) {
//                User user = (User) it.next();
//                System.out.println(user.toString());
//            }
            session.getTransaction().commit();

        } catch (Exception e) {
        }

        return users;
    }

    @Override
    public void cleanUsersTable() {
        try (org.hibernate.Session session = Util.getSessionFactory().openSession()){

            session.beginTransaction();
            session.createSQLQuery("DELETE FROM user;").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
        }

    }
}
