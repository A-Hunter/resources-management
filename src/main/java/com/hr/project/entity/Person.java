package com.hr.project.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Ghazi Naceur on 18/06/2017.
 */

@Entity
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="person_id")
    private long id;

    @Column(name="username")
    private String username;

    @Column(name="address")
    private String address;

    @Column(name="email")
    private String email;

    @OneToMany(mappedBy="owner")
    private Set<Car> cars;

    public Person(){
        super();
    }

    public Person(long id, String username, String address, String email, Set<Car> cars) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.email = email;
        this.cars = cars;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person other = (Person) obj;
        return id == other.id;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", address=" + address
                + ", email=" + email + "]";
    }
}
