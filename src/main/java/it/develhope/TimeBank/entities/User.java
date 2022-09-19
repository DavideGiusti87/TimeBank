package it.develhope.TimeBank.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.develhope.TimeBank.entities.request.Request;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "user")
public class User extends Person {
    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Request> requests;


    public User() {
    }

    public User(String password, Set<Request> requests) {
        this.password = password;
        this.requests = requests;
    }

    public User(Long id, String name, String surname, String username, String telephoneNumber, String email, Address address, Area area, String password, Set<Request> requests) {
        super(id, name, surname, username, telephoneNumber, email, address, area);
        this.password = password;
        this.requests = requests;
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
