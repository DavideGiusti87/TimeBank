package it.develhope.TimeBank.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.develhope.TimeBank.entities.request.Request;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "volunteers")
public class Volunteer extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @OneToMany(mappedBy = "volunteer")
    @JsonIgnore
    private List <Skill> skills;
    private boolean isAdmin = false;


        public Volunteer() {
    }

    public Volunteer(Long id, List<Skill> skills, boolean isAdmin) {
        Id = id;
        this.skills = skills;
        this.isAdmin = isAdmin;
    }

    public Volunteer(Long id, String name, String surname, String telephoneNumber, String email, Address address, Area area, String password, Set<Request> requests, Long id1, List<Skill> skills, boolean isAdmin) {
        super(id, name, surname, telephoneNumber, email, address, area, password, requests);
        Id = id1;
        this.skills = skills;
        this.isAdmin = isAdmin;
    }

    @Override
    public Long getId() {
        return Id;
    }

    @Override
    public void setId(Long id) {
        Id = id;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
