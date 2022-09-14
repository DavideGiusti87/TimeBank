package it.develhope.TimeBank.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.develhope.TimeBank.entities.request.Request;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="user")
public class User extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Enumerated
    private Area area;
    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Request> requests;


    public User() {
    }

    public User(Long id, Address address, Area area, String password, Set<Request> requests) {
        this.id = id;
        this.address = address;
        this.area = area;
        this.password = password;
        this.requests = requests;
    }

    public User(String name, String surname, String username, String telephoneNumber, String email, Long id, Address address, Area area, String password, Set<Request> requests) {
        super(name, surname, username, telephoneNumber, email);
        this.id = id;
        this.address = address;
        this.area = area;
        this.password = password;
        this.requests = requests;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Request> getRequests() {
        return requests;
    }

    public void setRequests(Set<Request> requests) {
        this.requests = requests;
    }
}
