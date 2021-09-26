package by.konovalchik.dao;

import by.konovalchik.entity.User;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersDAOImp implements UsersDAO {
    private static List<User> users = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(UsersDAOImp.class.getName());


    @Override
    public boolean addUser(User user) {
        if(users.contains(user)){
            logger.info("User already exists");
            return false;
        } else{
            users.add(user);
            logger.info("User {} registered ", user.getName());
            return true;
        }
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }

    public boolean containUserByEmail(String email){
        return users.stream().anyMatch(user -> user.getEmail().equals(email));
    }

    public void editUserPassword(String email, String newPassword){
        users.stream().filter(user -> user.getEmail().equals(email)).forEach(user -> user.setPassword(newPassword));
    }

    public void editUserName(String email, String newName){
        users.stream().filter(user -> user.getEmail().equals(email)).forEach(user -> user.setName(newName));
    }
}