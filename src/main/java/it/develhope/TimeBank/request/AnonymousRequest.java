package it.develhope.TimeBank.request;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class AnonymousRequest {

    @Id
    private long id;

    //variables declaration
    private String title;
    private String description;
    //private List<Skill> requiredSkills; - add class Skill first
    //private LocalDateTime dateTime; - ?
    private String name;
    private int phoneNumber;

    //empty constructor
    public AnonymousRequest() {
    }

    //parametric constructor
    public AnonymousRequest(String title, String description, String name, int phoneNumber) {
        this.title = title;
        this.description = description;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
