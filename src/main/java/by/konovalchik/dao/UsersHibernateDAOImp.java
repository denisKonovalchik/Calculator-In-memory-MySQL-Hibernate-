package by.konovalchik.dao;

import by.konovalchik.HibernateUtil;
import by.konovalchik.entity.User;
import org.apache.logging.log4j.LogManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersHibernateDAOImp implements UsersDAO {
    private static final Logger logger = LoggerFactory.getLogger(UsersHibernateDAOImp.class.getName());


    @Override
    public boolean addUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public List<User> getUsers() {
        Transaction transaction = null;
        List<User> users = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            users = session.createQuery("FROM User", User.class).getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        Transaction transaction = null;
        Optional<User> user = Optional.empty();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            user = Optional.of(session.createQuery("FROM User WHERE email = :paramEmail", User.class)
                                                   .setParameter("paramEmail", email).getSingleResult());
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean containUserByEmail(String email) {
        Transaction transaction = null;
        boolean check = false;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            List list  = session.createQuery("FROM User WHERE email = :paramEmail", User.class)
                                                 .setParameter("paramEmail", email).getResultList();
                 if(!list.isEmpty()){
                     check = true;
                 }
            transaction.commit();
        }catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public void editUserPassword(String email, String newPassword) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createQuery(" UPDATE User SET password = :newPassword WHERE email = :emailUser ")
                      .setParameter("emailUser", email)
                      .setParameter("newPassword", newPassword).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void editUserName(String email, String newName) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createQuery(" UPDATE User SET name = :newName1 WHERE email = :emailUser ")
                    .setParameter("newName1", newName)
                    .setParameter("emailUser", email).executeUpdate();
            transaction.commit();
            logger.info("User name changed. New name: {}", newName);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
