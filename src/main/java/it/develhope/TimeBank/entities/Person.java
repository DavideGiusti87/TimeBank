package it.develhope.TimeBank.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.develhope.TimeBank.entities.request.Request;
import jakarta.persistence.*;

import java.util.Set;

@MappedSuperclass
public class Person {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    private String username;
    @Column(unique = true, nullable = false)
    private String telephoneNumber;
    @Column(unique = true, nullable = false)
    private String email;

    public Person() {
    }

    public Person(String name, String surname, String username, String telephoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
