package by.konovalchik.dao;

import by.konovalchik.connections.MysqlConnection;
import by.konovalchik.entity.Operation;
import by.konovalchik.entity.User;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogOperationsMysqlDAOImp implements LogOperationsDAO{
    private static final Logger logger =  LoggerFactory.getLogger(LogOperationsMysqlDAOImp.class);

    @Override
    public void saveOperation(double num1, double num2, String operation, double result, User user) {
        try(Connection connection = MysqlConnection.getConnection()) {
            String sql = "INSERT INTO log_operations VALUES (NULL,?, ?, ?, ?, ?) ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, num1);
            statement.setDouble(2, num2);
            statement.setString(3, operation);
            statement.setDouble(4, result);
            statement.setInt(5, user.getId());
            logger.info("Save operation.");
            statement.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public List<Operation> showLogsByEmail(String email) {
        List<Operation> log = new ArrayList<>();
        try(Connection connection = MysqlConnection.getConnection()) {
            String sql = "SELECT l.num1, l.num2, l.operation, l.result, u.name " +
                         "FROM log_operations l " +
                         "LEFT JOIN users u ON u.id = l.user_id " +
                         "WHERE u.email = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
              log.add(new Operation(
                      resultSet.getDouble("num1"),
                      resultSet.getDouble("num2"),
                      resultSet.getString("operation"),
                      resultSet.getDouble("result"),
                      new User(resultSet.getString("name"))
              ));
            }
            logger.info("Request the history of user operations.");
            return log;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
