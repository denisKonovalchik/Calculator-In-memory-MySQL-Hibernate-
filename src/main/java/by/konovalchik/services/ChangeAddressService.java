package by.konovalchik.services;

import by.konovalchik.dao.UsersAddressesDAO;
import by.konovalchik.dao.UsersTelephonesDAO;
import by.konovalchik.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
public class ChangeAddressService {
        private final UsersAddressesDAO usersAddressesDAO;

        public boolean containAddressesById(int idTel, int idUser){
            return usersAddressesDAO.containAddressById(idTel, idUser);
        }

        public void updateAddressById(Address address){
            usersAddressesDAO.updateAddress(address);
        }
}
