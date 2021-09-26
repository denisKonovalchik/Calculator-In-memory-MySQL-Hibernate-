package by.konovalchik.services;


import by.konovalchik.dao.UsersTelephonesDAO;

import by.konovalchik.entity.Telephone;
import lombok.AllArgsConstructor;
import java.util.List;


@AllArgsConstructor
public class TelephonesUserService {
    private UsersTelephonesDAO usersTelephonesDAO;

    public void addTelephone(Telephone telephone){
        usersTelephonesDAO.addTelephone(telephone);
    }

    public void deleteTelephoneById(int id){
        usersTelephonesDAO.deleteTelephoneById(id);
    }

    public List<Telephone> findTelephoneByEmail(String email){
        return usersTelephonesDAO.findTelephoneByEmail(email);
    }

    public boolean containTelephoneById(int idTel, int idUser){
        return usersTelephonesDAO.containTelephoneById(idTel, idUser);
    }

    public boolean containTelephones(Telephone telephone) {
        return usersTelephonesDAO.containTelephone(telephone);
    }
}
