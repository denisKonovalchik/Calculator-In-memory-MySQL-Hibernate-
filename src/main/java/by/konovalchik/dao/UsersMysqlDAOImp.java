package by.konovalchik.dao;

import by.konovalchik.connections.MysqlConnection;
import by.konovalchik.entity.User;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersMysqlDAOImp implements UsersDAO {
    private static final Logger logger = LoggerFactory.getLogger(UsersMysqlDAOImp.class.getName());


    @Override
    public boolean addUser(User user) {
        try(Connection connection = MysqlConnection.getConnection()) {
            String sql = "INSERT INTO users VALUES (NULL, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            int result = statement.executeUpdate();
            if(result != 0) {
                logger.info("User {} registered ", user.getName());
                return true;
            }
        }catch(SQLException e ) {
            e.printStackTrace();
        }
        logger.info("User already exists");
        return false;
    }



    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try(Connection connection = MysqlConnection.getConnection()){
            String sql = "SELECT * FROM users";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                users.add(new User(
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                ));
            }
            return users;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }



    @Override
    public Optional<User> getUserByEmail(String email) {
        List<User> users = new ArrayList<>();
        try(Connection connection = MysqlConnection.getConnection()){
            String sql = "SELECT * FROM users WHERE email = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
               users.add(new User(
                             resultSet.getInt("id"),
                             resultSet.getString("name"),
                             resultSet.getString("email"),
                             resultSet.getString("password")
               ));

            }
            return users.stream().findFirst();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }


    @Override
    public boolean containUserByEmail(String email) {
        try(Connection connection = MysqlConnection.getConnection()){
            String sql = "SELECT id FROM users WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void editUserPassword(String email, String newPassword) {
        try(Connection connection = MysqlConnection.getConnection()){
            String sql = "UPDATE users SET password = ? WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newPassword);
            statement.setString(2, email);
            statement.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void editUserName(String email, String newName) {
        try(Connection connection = MysqlConnection.getConnection()){
            String sql = "UPDATE users SET name = ? WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newName);
            statement.setString(2, email);
            statement.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
