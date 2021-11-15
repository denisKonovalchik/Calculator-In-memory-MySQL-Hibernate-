package by.konovalchik.dao;

import by.konovalchik.entity.Operation;
import by.konovalchik.entity.User;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class LogOperationsDAOImp implements LogOperationsDAO {
    private static final Logger logger = LoggerFactory.getLogger(LogOperationsDAOImp.class.getName());
    private static final List<Operation> log = new ArrayList<>();


    @Override
    public void saveOperation(double num1, double num2, String operation, double  result, User user) {
        logger.info("Save operation");
        log.add(new Operation(num1, num2, operation, result, user));
    }


    @Override
    public List<Operation> showLogsByEmail(String email){
        List<Operation> logByEmail = new ArrayList<>();
        for(Operation operation: log){
            if(operation.getUser().getEmail().equals(email)){
                logByEmail.add(operation);
            }
        }
        logger.info("Request the history of user operations.");
        return logByEmail;
    }
}
