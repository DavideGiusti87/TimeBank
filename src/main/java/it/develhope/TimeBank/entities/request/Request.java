package it.develhope.TimeBank.entities.request;

import it.develhope.TimeBank.entities.Skill;
import it.develhope.TimeBank.entities.User;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String username;
    @ManyToMany(mappedBy = "request")
    private Set<Skill> skill = new HashSet<>();

    public Request() {
    }

    public Request(long id, User user, String username, Set<Skill> skill) {
        this.id = id;
        this.user = user;
        this.username = username;
        this.skill = skill;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Skill> getSkill() {
        return skill;
    }

    public void setSkill(Set<Skill> skills) {
        this.skill = skill;
    }
}
