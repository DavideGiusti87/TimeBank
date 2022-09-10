package it.develhope.TimeBank.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String streetNumber;
    private String city;
    private String zipCode;

    @OneToMany(mappedBy = "address")
    @JsonIgnore
    private Set<User> users;

    @OneToMany(mappedBy = "address")
    @JsonIgnore
    private Set <Guest> guests;


    public Address() {
    }

    public Address(Long id, String street, String streetNumber, String city, String zipCode) {
        this.id = id;
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.zipCode = zipCode;
    }

    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
