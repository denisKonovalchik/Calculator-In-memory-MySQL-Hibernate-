package by.konovalchik.dao;

import by.konovalchik.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UsersDAOImpTest {
private static UsersDAOImp dao = new UsersDAOImp();


    @BeforeAll
    static void setUp(){


            dao.addUser(new User("Denis","dennkon@tut.by","12345"));
            dao.addUser(new User("Olga","olga@tut.by","123456"));

    }

    @Test
    void addUser() {

    }

    @Test
    void getUsers() {
    }

    @Test
    void getUserByEmail() {
    }

    @Test
    void containUserByEmail() {
    }

    @Test
    void editUserPassword() {
    }

    @Test
    void editUserName() {
    }
}