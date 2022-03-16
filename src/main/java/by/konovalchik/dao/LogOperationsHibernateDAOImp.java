package by.konovalchik.dao;

import by.konovalchik.HibernateUtil;
import by.konovalchik.entity.Operation;
import by.konovalchik.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class LogOperationsHibernateDAOImp implements LogOperationsDAO {

    @Override
    public void saveOperation(double num1, double num2, String operation, double result, User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(new Operation(num1, num2, operation, result, user));
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    @Override
    public List<Operation> showLogsByEmail(String email) {
        Transaction transaction = null;
        List<Operation> log = new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
             List list = session.createQuery(" FROM Operation op LEFT JOIN op.user user " +
                                                " WHERE user.email = :emailUser ")
                                                .setParameter("emailUser", email).list();
             log = getListOperation(list);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return log;
    }


    private List<Operation> getListOperation(List list){
        List<Operation> log = new ArrayList<>();
        for (Object o : list) {
            Object[] row = (Object[]) o;
            Operation op = (Operation) row[0];
            User user = (User) row[1];
            Operation operation = new Operation(
                    op.getNum1(),
                    op.getNum2(),
                    op.getOperation(),
                    op.getResult(),
                    new User(user.getName()));
            log.add(operation);
        }
        return  log;
    }
}
