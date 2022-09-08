package it.develhope.TimeBank.entities.request;

import it.develhope.TimeBank.entities.Area;
import it.develhope.TimeBank.entities.Skill;
import it.develhope.TimeBank.entities.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Request extends AbstractRequest{

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String username;

    /*
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private Area area;


    public Request() {}

    public Request(String title, String description, String name, int phoneNumber) {
        super(title, description, name, phoneNumber);
    }
*/

    public Request(long id, User user, String username) {
        this.id = id;
        this.user = user;
        this.username = username;
    }

    public Request(String title, String description, String name, int phoneNumber, List<Skill> requiredSkill, LocalDate localDate, Area area, long id, User user, String username) {
        super(title, description, name, phoneNumber, requiredSkill, localDate, area);
        this.id = id;
        this.user = user;
        this.username = username;
    }

    public Request() {
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
}
