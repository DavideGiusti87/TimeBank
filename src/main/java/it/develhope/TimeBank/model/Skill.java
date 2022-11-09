package it.develhope.TimeBank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "skill")
public class Skill extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private List<User> users;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Request> request;

    public Skill() {
    }

    public Skill(Long id, String name, String description, List<User> users, Set<Request> request) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.users = users;
        this.request = request;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Set<Request> getRequest() {
        return request;
    }

    public void setRequest(Set<Request> request) {
        this.request = request;
    }
}
