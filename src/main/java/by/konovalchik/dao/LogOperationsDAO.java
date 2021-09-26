package by.konovalchik.dao;

import by.konovalchik.entity.Operation;
import by.konovalchik.entity.User;

import java.util.List;

public interface LogOperationsDAO {

    void saveOperation(double num1, double num2, String operation, double  result, User user);

    List<Operation> showLogsByEmail(String email);
}
