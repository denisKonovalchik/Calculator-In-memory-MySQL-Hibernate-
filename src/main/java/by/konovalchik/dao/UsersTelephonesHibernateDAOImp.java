package by.konovalchik.dao;

import by.konovalchik.HibernateUtil;
import by.konovalchik.entity.Address;
import by.konovalchik.entity.Telephone;
import by.konovalchik.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersTelephonesHibernateDAOImp implements UsersTelephonesDAO{


    @Override
    public void addTelephone(Telephone telephone) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(telephone);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    @Override
    public void updateTelephoneById(int id, long newNumber) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Telephone telephoneUp = session.find(Telephone.class, id);
            telephoneUp.setNumber(newNumber);
            session.merge(telephoneUp);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    @Override
    public void deleteTelephoneById(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Telephone telephoneDel = session.load(Telephone.class, id);
            session.delete(telephoneDel);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    @Override
    public List<Telephone> findTelephoneByEmail(String email) {
        Transaction transaction = null;
        List<Telephone> telephones = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
              List list = session.createQuery(" FROM Telephone as tel LEFT JOIN tel.user user " +
                                                  " WHERE user.email = :emailUser ")
                                                  .setParameter("emailUser", email)
                                                  .list();
              telephones = getListTelephone(list);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return telephones;
    }


    @Override
    public boolean containTelephoneById(int idTel, int idUser) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List list = session.createQuery(" FROM Telephone as tel LEFT JOIN tel.user user " +
                                               " WHERE tel.id = :idTel AND user.id = :idUser ")
                                                .setParameter("idTel", idTel)
                                                .setParameter("idUser", idUser)
                                                .list();
            if(!list.isEmpty()){
                return true;
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean containTelephone(Telephone telephone) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List list = session.createQuery(
                                          " FROM Telephone as tel  WHERE " +
                                             " tel.number = :paramNumber AND tel.user.id = :paramId ", Telephone.class)
                                             .setParameter("paramNumber", telephone.getNumber())
                                             .setParameter("paramId", telephone.getUser().getId())
                                             .list();
            if(!list.isEmpty()){
                return true; }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }


    private List<Telephone> getListTelephone(List list){
        List<Telephone> telephones = new ArrayList<>();
        for (Object o : list) {
            Object[] row = (Object[]) o;
            Telephone tel = (Telephone) row[0];
            User user = (User) row[1];
            Telephone telephone = new Telephone(
                    tel.getId(),
                    tel.getNumber(),
                    new User(user.getName()));
            telephones.add(telephone);
        }
        return  telephones;
    }


}
