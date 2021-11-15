package by.konovalchik.services;

import by.konovalchik.dao.LogOperationsDAO;
import by.konovalchik.entity.Operation;
import by.konovalchik.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


@AllArgsConstructor
public class LogOperationsService {
 private final LogOperationsDAO daoLog;


    public void saveOperation(double num1, double num2, String operation, double result, User user){
             daoLog.saveOperation(num1, num2, operation, result, user);
    }

    public List<Operation> showLogsByEmail(String email){
         return daoLog.showLogsByEmail(email);
    }


}
