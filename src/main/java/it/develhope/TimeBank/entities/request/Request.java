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


    public Request() {
    }

    public Request(long id, User user) {
        this.id = id;
        this.user = user;
    }

    public Request(String title, String description, String name, int phoneNumber, List<Skill> requiredSkill, LocalDate localDate, Area area, long id, User user) {
        super(title, description, name, phoneNumber, requiredSkill, localDate, area);
        this.id = id;
        this.user = user;
    }

    /* public Request(long id, String email, Area area) {
        this.id = id;
        this.email = email;
        this.area = area;
    }

    public Request(String title, String description, String name, int phoneNumber, List<Skill> requiredSkill, LocalDate localDate, Area area, long id, String email, Area area1) {
        super(title, description, name, phoneNumber, requiredSkill, localDate, area);
        this.id = id;
        this.email = email;
        this.area = area1;
    }

    public Request(String title, String description, String name, int phoneNumber, List<Skill> requiredSkill, LocalDate localDate, Area area) {
        super(title, description, name, phoneNumber, requiredSkill, localDate, area);
    } */

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

    /*  public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    } */
}
