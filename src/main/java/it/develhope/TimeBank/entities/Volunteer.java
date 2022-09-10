package it.develhope.TimeBank.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.develhope.TimeBank.entities.request.Request;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "volunteers")
public class Volunteer extends User{


    @OneToMany(mappedBy = "volunteer")
    @JsonIgnore
    private List <Skill> skill;
    private boolean isAdmin = false;


        public Volunteer() {
    }

    public Volunteer(List<Skill> skill, boolean isAdmin) {
        this.skill = skill;
        this.isAdmin = isAdmin;
    }

    public Volunteer(Long id, String name, String surname, String username, String telephoneNumber, String email, Address address, Area area, String password, Set<Request> requests, List<Skill> skill, boolean isAdmin) {
        super(id, name, surname, username, telephoneNumber, email, address, area, password, requests);
        this.skill = skill;
        this.isAdmin = isAdmin;
    }

    public List<Skill> getSkill() {
        return skill;
    }

    public void setSkill(List<Skill> skill) {
        this.skill = skill;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
