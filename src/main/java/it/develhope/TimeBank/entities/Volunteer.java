package it.develhope.TimeBank.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "volunteer")
public class Volunteer extends User{

    @Id
    private Long id = getId();
    private String name = getName();
    private String surname = getSurname();
    private String telephoneNumber = getTelephoneNumber();
    private String email = getEmail();
    private Address address = getAddress();
    private String password = getPassword();
    private List <Skill> skills;

    public Volunteer() {
    }

    public Volunteer(Long id, String name, String surname, String telephoneNumber, String email, Address address, Area area, String password, List <Skill> skills) {
        super(id, name, surname, telephoneNumber, email, address, area, password);
        this.skills = skills;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    @Override
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
