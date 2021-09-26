package by.konovalchik.services;


import by.konovalchik.dao.UsersTelephonesDAO;
import by.konovalchik.entity.Telephone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public class AddTelephoneService {
    private UsersTelephonesDAO usersTelephonesDAO;


    public boolean containTelephone(Telephone telephone){
        return usersTelephonesDAO.containTelephone(telephone);
    }

    public void addTelephone(Telephone telephone){
        usersTelephonesDAO.addTelephone(telephone);
    }


}
