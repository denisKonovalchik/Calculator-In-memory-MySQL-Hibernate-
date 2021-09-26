package by.konovalchik.dao;

import by.konovalchik.HibernateUtil;
import by.konovalchik.entity.Address;
import by.konovalchik.entity.Operation;
import by.konovalchik.entity.User;
import by.konovalchik.servlets.ChangeAddressServlet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersAddressesHibernateDAOImp implements UsersAddressesDAO {
    private static final Logger logger = LoggerFactory.getLogger(UsersAddressesHibernateDAOImp.class);

    @Override
    public void addAddress(Address address) {
            Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(address);
            transaction.commit();
            logger.info("Address added!");
        } catch (Exception e) {
            if (transaction != null) {
                logger.info("Address has not changed!");
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    @Override
    public void updateAddress(Address address) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Address addressUp = session.load(Address.class, address.getId());
            addressUp.setCity(address.getCity());
            addressUp.setStreet(address.getStreet());
            addressUp.setHomeNumber(address.getHomeNumber());
            addressUp.setApartNumber(address.getApartNumber());
            session.merge(addressUp);
            transaction.commit();
            logger.info("Address changed!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    @Override
    public void deleteAddressById(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Address addressUp = session.load(Address.class, id);
            session.delete(addressUp);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    @Override
    public boolean isExist(int idUser) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List list = session.createQuery(" FROM Address addr WHERE addr.user.id = :idUser1")
                                               .setParameter("idUser1", idUser).list();
            int sizeAddr = list.size();
                if(sizeAddr > 1){
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
    public List<Address> findAllAddressesByEmail(String email) {
        Transaction transaction = null;
        List<Address> addresses = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List list = session.createQuery(" FROM Address as ad LEFT JOIN ad.user user" +
                                               " WHERE user.email = :emailUser ")
                                               .setParameter("emailUser", email)
                                               .list();

            addresses = getListAddresses(list);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return addresses;
    }


    @Override
    public boolean containAddressById(int idAddr, int idUser) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List list = session.createQuery(" FROM Address as ad LEFT JOIN ad.user user " +
                    " WHERE ad.id = :idAddr1 AND user.id = :idUser1 ")
                    .setParameter("idAddr1", idAddr)
                    .setParameter("idUser1", idUser)
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
    public boolean containAddress(Address address) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List list = session.createQuery(" FROM Address as ad  WHERE " +
                                   " ad.city = :paramCity AND " +
                                   " ad.street = :paramStreet AND " +
                                   " ad.homeNumber = :paramHomeNumber AND " +
                                   " ad.apartNumber = :paramApartNumber AND " +
                                   " ad.user.id = :paramUserId ")
                                   .setParameter("paramCity", address.getCity())
                                   .setParameter("paramStreet", address.getStreet())
                                   .setParameter("paramHomeNumber", address.getHomeNumber())
                                   .setParameter("paramApartNumber", address.getApartNumber())
                                   .setParameter("paramUserId", address.getUser().getId())
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


    private List<Address> getListAddresses(List list){
        List<Address> addresses = new ArrayList<>();
        for (Object o : list) {
            Object[] row = (Object[]) o;
            Address ad = (Address) row[0];
            User user = (User) row[1];
            Address address = new Address(
                    ad.getId(),
                    ad.getCity(),
                    ad.getStreet(),
                    ad.getHomeNumber(),
                    ad.getApartNumber(),
                    new User(user.getName()));
            addresses.add(address);
        }
        return  addresses;
    }

}
