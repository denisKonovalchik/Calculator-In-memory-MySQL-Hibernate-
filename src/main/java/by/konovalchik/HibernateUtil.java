package by.konovalchik;

import by.konovalchik.entity.Address;
import by.konovalchik.entity.Operation;
import by.konovalchik.entity.Telephone;
import by.konovalchik.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory(){
       if(sessionFactory == null){
           try {
               Configuration configuration = new Configuration();
               Properties setting = new Properties();
               setting.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
               setting.put(Environment.URL, "jdbc:mysql://localhost:3306/calculator22?serverTimezone=UTC");
               setting.put(Environment.USER, "root");
               setting.put(Environment.PASS, "root");
               setting.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
               setting.put(Environment.SHOW_SQL, "true");
               setting.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
               setting.put(Environment.HBM2DDL_AUTO, "create-drop");
               configuration.setProperties(setting);
               configuration.addAnnotatedClass(User.class);
               configuration.addAnnotatedClass(Operation.class);
               configuration.addAnnotatedClass(Address.class);
               configuration.addAnnotatedClass(Telephone.class);
               ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                       .applySettings(configuration.getProperties()).build();
               System.out.println("Hibernate Java Config serviceRegistry created");
               sessionFactory = configuration.buildSessionFactory(serviceRegistry);
           }catch(HibernateException e){
               e.printStackTrace();
           }
       }
       return sessionFactory;
    }

}
