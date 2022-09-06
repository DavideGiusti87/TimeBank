package it.develhope.TimeBank.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "volunteers")
public class Volunteer extends User{

    private List <Skill> skills;
    private boolean isAdmin = false;

        public Volunteer() {
    }

    public Volunteer(List<Skill> skills, boolean isAdmin) {
        this.skills = skills;
        this.isAdmin = isAdmin;
    }

    public Volunteer(Long id, String name, String surname, String telephoneNumber, String email, Address address, Area area, String password, List<Skill> skills, boolean isAdmin) {
        super(id, name, surname, telephoneNumber, email, address, area, password);
        this.skills = skills;
        this.isAdmin = isAdmin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
