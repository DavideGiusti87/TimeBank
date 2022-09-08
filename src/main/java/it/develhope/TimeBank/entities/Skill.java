package it.develhope.TimeBank.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "Volunteer_Skill")
    private Volunteer volunteer;

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
