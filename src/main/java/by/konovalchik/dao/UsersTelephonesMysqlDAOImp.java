package by.konovalchik.dao;

import by.konovalchik.connections.MysqlConnection;
import by.konovalchik.entity.Telephone;
import by.konovalchik.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsersTelephonesMysqlDAOImp implements UsersTelephonesDAO {
    private static final Logger logger =  LoggerFactory.getLogger(LogOperationsMysqlDAOImp.class);


    @Override
    public void addTelephone(Telephone telephone) {
       try(Connection connection = MysqlConnection.getConnection()){
           String sql = " INSERT INTO telephones  VALUES (NULL, ?, ?) ";
           PreparedStatement statement = connection.prepareStatement(sql);
           statement.setLong(1, telephone.getNumber());
           statement.setInt(2, telephone.getUser().getId());
           logger.info("Save telephone. ");
           statement.execute();
       }catch(SQLException e){
           e.printStackTrace();
        }
    }

    @Override
    public void updateTelephoneById(int id, long newNumber) {
        try(Connection connection = MysqlConnection.getConnection()){
            String sql = "UPDATE telephones SET number = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, newNumber);
            statement.setInt(2, id);
            statement.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public void deleteTelephoneById(int id) {
        try(Connection connection = MysqlConnection.getConnection()){
            String sql = "DELETE FROM telephones WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public List<Telephone> findTelephoneByEmail(String email) {
        List<Telephone> telephones = new ArrayList<>();
        try (Connection connection = MysqlConnection.getConnection()) {
            String sql = " SELECT * FROM telephones tel " +
                         " LEFT JOIN  users us ON tel.user_id = us.id " +
                         " WHERE  us.email = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                telephones.add(new Telephone(
                        resultSet.getInt("id"),
                        resultSet.getLong("number"),
                        new User(resultSet.getInt("user_id"))
                ));
            }
            return telephones;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return telephones;
    }


    @Override
    public boolean containTelephoneById(int idTel, int idUser) {
        try (Connection connection = MysqlConnection.getConnection()) {
            String sql = " SELECT * FROM telephones tel " +
                    " WHERE  tel.id = ? AND tel.user_id = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idTel);
            statement.setInt(2, idUser);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean containTelephone(Telephone telephone) {
        try (Connection connection = MysqlConnection.getConnection()) {
            String sql = " SELECT * FROM telephones tel " +
                    " WHERE  tel.number = ? AND tel.user_id = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, telephone.getNumber());
            statement.setInt(2, telephone.getUser().getId());
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
