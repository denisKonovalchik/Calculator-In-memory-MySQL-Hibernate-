package by.konovalchik.dao;

import by.konovalchik.entity.Address;
import by.konovalchik.entity.Telephone;

import java.util.List;

public interface UsersAddressesDAO {

    void addAddress(Address address) ;
    void updateAddress(Address address);
    void deleteAddressById(int id);
    List<Address> findAllAddressesByEmail(String email);
    boolean containAddressById(int idAddr, int idUser);
    boolean containAddress(Address address);
    boolean isExist(int idUser);

}
