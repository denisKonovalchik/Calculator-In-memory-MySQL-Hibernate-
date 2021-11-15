package by.konovalchik.services;

import by.konovalchik.dao.UsersDAO;
import by.konovalchik.entity.User;
import by.konovalchik.services.facade.FacadeDependencies;
import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;


@AllArgsConstructor
public class AuthorizationUserService {
    private static final Logger logger = LogManager.getLogger();
    private final UsersDAO daoUsers;

    public Optional<User> authorizationUser(String email, String password) {
        if(daoUsers.getUserByEmail(email).isPresent()){
            if(daoUsers.getUserByEmail(email).get().getPassword().equals(password)) {
                logger.info("User {} has been sign in", daoUsers.getUserByEmail(email).get().getName());
                return daoUsers.getUserByEmail(email);
            }
        }
        logger.info("User not found");
        return Optional.empty();
    }

}
