package by.konovalchik.services;

import by.konovalchik.dao.UsersAddressesDAO;
import by.konovalchik.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
public class AddAddressService {
    private final UsersAddressesDAO usersAddressesDAO;


    public boolean containAddress(Address address) {
        return usersAddressesDAO.containAddress(address);
    }


    public void addAddress(Address address) {
        usersAddressesDAO.addAddress(address);
    }

}