package by.konovalchik.dao;

import by.konovalchik.entity.Operation;
import by.konovalchik.entity.User;

import java.util.ArrayList;
import java.util.List;

public class LogsOperationsDAOImp implements LogsOperationsDAO {
    private static List<Operation> logsOperations = new ArrayList<>();


    @Override
    public void saveOperation(double num1, double num2, String operation, double result, User user) {
        logsOperations.add(new Operation(num1,num2, operation, result, user));
    }

    @Override
    public List<Operation> showLogs() {
        return logsOperations;
    }

    public List<Operation> showLogsByLogin(String login){
        List<Operation> logsLogin = new ArrayList<>();
        for(Operation operation: logsOperations){
            if(operation.getUser().getLogin().equals(login)){
                logsLogin.add(operation);
            }
        }
        return logsLogin;
    }
}
