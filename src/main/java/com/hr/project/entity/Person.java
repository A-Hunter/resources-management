package com.hr.project.entity;

/**
 * Created by Ghazi Naceur on 18/06/2017.
 */
public class Person {

    private long id;

    private String username;

    private String address;

    private String email;

    public Person(){
        super();
    }

    public Person(long id, String username, String address, String email){
        this.id = id;
        this.username = username;
        this.address = address;
        this.email = email;
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
