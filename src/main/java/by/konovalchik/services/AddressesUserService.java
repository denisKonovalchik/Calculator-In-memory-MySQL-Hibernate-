package by.konovalchik.services;

import by.konovalchik.dao.UsersAddressesDAO;
import by.konovalchik.entity.Address;
import lombok.AllArgsConstructor;

import java.util.List;


@AllArgsConstructor
public class AddressesUserService {
    private UsersAddressesDAO usersAddressesDAO;


    public void addAddress(Address address){
         usersAddressesDAO.addAddress(address);
    }

   public void deleteAddressById(int id) {
        usersAddressesDAO.deleteAddressById(id);
    }

    public boolean isExist(int idUser){
        return usersAddressesDAO.isExist(idUser);
    }


   public List<Address> findAllAddressesByEmail(String email){
        return usersAddressesDAO.findAllAddressesByEmail(email);
    }

    public boolean containAddressById(int idAddr, int idUser){
        return usersAddressesDAO.containAddressById(idAddr, idUser);
    }

    public boolean containAddress(Address address) {
        return usersAddressesDAO.containAddress(address);
    }

}
