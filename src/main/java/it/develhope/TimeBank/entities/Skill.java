package it.develhope.TimeBank.entities;


import it.develhope.TimeBank.entities.request.Request;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private Volunteer volunteer;

    @ManyToMany
    @JoinTable(name = "skill_request",
            joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "request_id"))

    private Set<Request> request = new HashSet<>();

    public Set<Request> getRequest() {
        return request;
    }

    public void setRequests(Set<Request> request) {
        this.request = request;
    }

    public Skill() {
    }

    public Skill(Long id, String name, String description, Volunteer volunteer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.volunteer = volunteer;
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

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

}
