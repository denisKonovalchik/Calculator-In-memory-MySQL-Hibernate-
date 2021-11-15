package by.konovalchik.services;

import by.konovalchik.dao.UsersDAO;
import by.konovalchik.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

@AllArgsConstructor
public class ChangeNameService {
    private final UsersDAO daoUsers;


    public void changeName(String email, String name) {
        daoUsers.editUserName(email, name);
    }
}
