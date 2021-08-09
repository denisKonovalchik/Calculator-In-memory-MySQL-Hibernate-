package by.konovalchik.dao;

import by.konovalchik.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UsersDAOImp implements UsersDAO {
    private  static List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
     users.add(user);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUserByLogin(String login) {
        for(User user: users){
            if(user.getLogin().equals(login)){
                return  user;
            }
        }
        return new User();
    }
}
