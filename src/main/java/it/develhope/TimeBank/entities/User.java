package it.develhope.TimeBank.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.develhope.TimeBank.entities.request.Request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
