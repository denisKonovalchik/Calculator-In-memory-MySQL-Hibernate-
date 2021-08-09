package by.konovalchik.dao;

import by.konovalchik.entity.User;

import java.util.List;

public interface UsersDAO {

    void addUser(User user);

    List<User> getUsers();

    User getUserByLogin(String login);
}
