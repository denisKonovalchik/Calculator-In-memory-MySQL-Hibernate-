package by.konovalchik.dao;

import by.konovalchik.entity.Operation;
import by.konovalchik.entity.User;

import java.util.ArrayList;
import java.util.List;

public class LogOperationsDAOImp implements LogOperationsDAO {
    private static List<Operation> logOperations = new ArrayList<>();


    @Override
    public void saveOperation(double num1, double num2, String operation, double result, User user) {
        logOperations.add(new Operation(num1,num2, operation, result, user));
    }

    @Override
    public List<Operation> showLogs() {
        return logOperations;
    }

    public List<Operation> showLogsByLogin(String login){
        List<Operation> logByLogin = new ArrayList<>();
        for(Operation operation: logOperations){
            if(operation.getUser().getLogin().equals(login)){
                logByLogin.add(operation);
            }
        }
        return logByLogin;
    }
}
