package it.develhope.TimeBank.entities;


import it.develhope.TimeBank.entities.request.Request;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String description;

    @ManyToMany
    @JoinTable(name = "skills_request",
            joinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "request_id"))
    private Set<Request> requests = new LinkedHashSet<>();

    public Set<Request> getRequests() {
        return requests;
    }

    public void setRequests(Set<Request> requests) {
        this.requests = requests;
    }

    public Skill() {
    }

    public Skill(Long id, String description, String name) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
