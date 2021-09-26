package by.konovalchik.dao;

import by.konovalchik.HibernateUtil;
import by.konovalchik.connections.MysqlConnection;
import by.konovalchik.entity.Address;
import by.konovalchik.entity.Telephone;
import by.konovalchik.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersAddressesMysqlDAOImp implements UsersAddressesDAO{
    private Logger logger = LoggerFactory.getLogger(UsersAddressesMysqlDAOImp.class);


    @Override
    public void addAddress(Address address) {
        try(Connection connection = MysqlConnection.getConnection()){
            String sql = " INSERT INTO addresses  VALUES (NULL, ?, ?, ?, ?, ?) ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, address.getCity());
            statement.setString(2, address.getStreet());
            statement.setInt(3,address.getHomeNumber());
            statement.setInt(4,address.getApartNumber());
            statement.setInt(5,address.getUser().getId());
            logger.info("Save address. ");
            statement.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public void updateAddress(Address address) {
        try(Connection connection = MysqlConnection.getConnection()){
            String sql = " UPDATE addresses a " +
                         " SET a.city = ?, a.street = ?, a.homeNumber = ?, a.apartNumber = ? " +
                         " WHERE a.id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, address.getCity());
            statement.setString(2, address.getStreet());
            statement.setInt(3,address.getHomeNumber());
            statement.setInt(4,address.getApartNumber());
            statement.setInt(5, address.getId());
            statement.execute();
            logger.info("Update address. ");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public void deleteAddressById(int id) {
        try(Connection connection = MysqlConnection.getConnection()){
            String sql = "DELETE FROM addresses WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
            logger.info("Delete address. ");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public List<Address> findAllAddressesByEmail(String email) {
        List<Address> addresses = new ArrayList<>();
        try (Connection connection = MysqlConnection.getConnection()) {
            String sql = " SELECT * FROM addresses a " +
                    " LEFT JOIN  users us ON a.user_id = us.id " +
                    " WHERE  us.email = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                addresses.add(new Address(
                        resultSet.getInt("id"),
                        resultSet.getString("city"),
                        resultSet.getString("street"),
                        resultSet.getInt("homeNumber"),
                        resultSet.getInt("apartNumber"),
                        new User(resultSet.getInt("user_id"))
                ));
            }
            return addresses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }


    @Override
    public boolean containAddressById(int idAddr, int idUser) {
        try (Connection connection = MysqlConnection.getConnection()) {
            String sql = " SELECT * FROM addresses a " +
                    " WHERE  a.id = ? AND a.user_id = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idAddr);
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
    public boolean containAddress(Address address) {
        try (Connection connection = MysqlConnection.getConnection()) {
            String sql = " SELECT * FROM addresses a " +
                    " WHERE  a.city = ? AND  a.street = ? AND a.homeNumber = ? AND a.apartNumber = ? AND a.user_id = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, address.getCity());
            statement.setString(2, address.getStreet());
            statement.setInt(3, address.getHomeNumber());
            statement.setInt(4, address.getApartNumber());
            statement.setInt(5, address.getUser().getId());
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
    public boolean isExist(int idUser) {
        List<Integer> counts = new ArrayList<>();
        try (Connection connection = MysqlConnection.getConnection()) {
            String sql = " SELECT * FROM addresses a WHERE a.user_id = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idUser);
            ResultSet resultSet= statement.executeQuery();
            while(resultSet.next()){
              counts. add(resultSet.getInt("id"));
            }
            if(counts.size() > 1) return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
