package by.konovalchik.services;

import by.konovalchik.dao.UsersDAO;
import by.konovalchik.entity.User;
import by.konovalchik.services.facade.CalculatorFacade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@AllArgsConstructor
public class ChangePasswordService {
    private final UsersDAO daoUser;

    public void editUserPassword(String email, String newUserPassword){
        daoUser.editUserPassword(email, newUserPassword);
    }

    public boolean checkPassword(String newPassword, String confirmPassword){
        return newPassword.equals(confirmPassword);
    }

}
