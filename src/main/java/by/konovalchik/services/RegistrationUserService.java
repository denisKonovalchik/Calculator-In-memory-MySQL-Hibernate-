package by.konovalchik.services;

import by.konovalchik.dao.UsersDAO;
import by.konovalchik.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@AllArgsConstructor
public class RegistrationUserService{
    private final UsersDAO daoUsers;


    public boolean containUserByEmail(String email){
        return daoUsers.containUserByEmail(email);
    }

    public void registrationUser(User user){
        daoUsers.addUser(user);
    }

    public Optional<User> getUserByEmail(String email) {
        return daoUsers.getUserByEmail(email);
    }

}


