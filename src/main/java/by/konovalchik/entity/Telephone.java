package by.konovalchik.entity;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "telephones")
public class Telephone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long number;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    public Telephone(int id, long number, User user) {
        this.id = id;
        this.number = number;
        this.user = user;
    }

    public Telephone(long number, User user) {
        this.number = number;
        this.user = user;
    }

    public Telephone(long number) {
        this.number = number;
    }


    public Telephone() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
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
        Telephone telephone = (Telephone) o;
        return id == telephone.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "id=" + id +
                ", number=" + number +
                ", user=" + user +
                '}';
    }
}
