package it.develhope.TimeBank.entities;

import javax.persistence.*;

@MappedSuperclass
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    private String username;
    @Column(unique = true, nullable = false)
    private String telephoneNumber;
    @Column(unique = true, nullable = false)
    private String email;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Enumerated
    private Area area;

    public Person() {
    }

    public Person(Long id, String name, String surname, String username, String telephoneNumber, String email, Address address, Area area) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.address = address;
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
