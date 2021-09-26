package by.konovalchik.services;


import by.konovalchik.dao.UsersTelephonesDAO;
import by.konovalchik.entity.Telephone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class ChangeTelephoneService {
    private UsersTelephonesDAO usersTelephonesDAO;


    public boolean containTelephoneById(int idTel, int idUser){
        return usersTelephonesDAO.containTelephoneById(idTel, idUser);
    }

    public void updateTelephoneById(int id, long newNumber){
        usersTelephonesDAO.updateTelephoneById(id, newNumber);
    }
}
