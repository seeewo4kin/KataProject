package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String  sql = "CREATE TABLE IF NOT EXIST users " +
                "(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(50) NOT NULL, lastname VARCHAR(50) NOT NULL, " +
                "age TINYINT NOT NULL)";
        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "DROP TABLE IF EXIST users";

        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();
        transaction.commit();
        session.close();

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = getSessionFactory().openSession();
        User user = new User(name, lastName, age);

        session.persist(user);
        session.flush();
        session.clear();
    }

    @Override
    public void removeUserById(long id) {
        Session session = getSessionFactory().openSession();
        User user = (User) session.find(User.class, id );
        session.remove(user);
        session.flush();
        session.clear();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = getSessionFactory().openSession();
        return session.createQuery("SELECT a FROM User a", User.class).getResultList();

    }

    @Override
    public void cleanUsersTable() {
        Session session = getSessionFactory().openSession();
        List<User> users = new ArrayList<>();
        users = session.createQuery("SELECT a FROM User a", User.class).getResultList();

        for (user : users) {

        }
    }
}
