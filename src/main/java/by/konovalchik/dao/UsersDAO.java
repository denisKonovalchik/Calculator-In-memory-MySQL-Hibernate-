package by.konovalchik.dao;

import by.konovalchik.entity.User;

import java.util.List;
import java.util.Optional;

public interface UsersDAO {

    boolean addUser(User user);

    List<User> getUsers();

    Optional<User> getUserByEmail(String email);

    boolean containUserByEmail(String email);

    void editUserPassword(String email, String newPassword);

    void editUserName(String email, String name);

}
