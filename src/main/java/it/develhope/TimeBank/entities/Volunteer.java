package it.develhope.TimeBank.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name = "volunteer")
public class Volunteer extends Person {


    @OneToMany(mappedBy = "volunteer")
    @JsonIgnore
    private List<Skill> skill;
    private boolean isAdmin = false;


    public Volunteer() {
    }

    public Volunteer(List<Skill> skill, boolean isAdmin) {
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
