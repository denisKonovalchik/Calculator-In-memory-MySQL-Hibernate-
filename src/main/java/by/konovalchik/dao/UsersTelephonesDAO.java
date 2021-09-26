package by.konovalchik.dao;

import by.konovalchik.entity.Telephone;

import java.util.List;

public interface UsersTelephonesDAO {

    void addTelephone(Telephone telephone);
    void updateTelephoneById(int id, long newNumber);
    void deleteTelephoneById(int id);
    List<Telephone> findTelephoneByEmail(String email);
    boolean containTelephoneById(int idTel, int idUser);
    boolean containTelephone(Telephone telephone);
}
