package it.develhope.TimeBank.entities;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;

@Entity
@Table
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Id", notes = "Id of Address")
    private Long id;
    @ApiModelProperty(value = "street", notes = "street of address")
    private String street;
    @ApiModelProperty(value = "streetNumber", notes = "streetNumber of address")
    private String streetNumber;
    @ApiModelProperty(value = "city", notes = "city of address")
    private String city;
    @ApiModelProperty(value = "zipCode", notes = "zipCode of address")
    private String zipCode;

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
