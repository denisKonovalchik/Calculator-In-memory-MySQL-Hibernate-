package by.konovalchik.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String city;
    private String street;
    private int homeNumber;
    private int apartNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="user_id")
    private User user;


    public Address(int id, String city, String street, int homeNumber, int apartNumber, User user) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.homeNumber = homeNumber;
        this.apartNumber = apartNumber;
        this.user = user;
    }

    public Address(String city, String street, int homeNumber, int apartNumber, User user) {
        this.city = city;
        this.street = street;
        this.homeNumber = homeNumber;
        this.apartNumber = apartNumber;
        this.user = user;
    }

    public Address(String city, String street, int homeNumber, int apartNumber) {
        this.city = city;
        this.street = street;
        this.homeNumber = homeNumber;
        this.apartNumber = apartNumber;
    }

    public Address(int id) {
        this.id = id;
    }

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }

    public int getApartNumber() {
        return apartNumber;
    }

    public void setApartNumber(int apartNumber) {
        this.apartNumber = apartNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", homeNumber=" + homeNumber +
                ", apartNumber=" + apartNumber +
                ", user=" + user +
                '}';
    }
}
