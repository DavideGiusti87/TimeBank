package it.develhope.TimeBank.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "volunteers")
public class Volunteer extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private List <Skill> skills;
    private boolean isAdmin = false;

        public Volunteer() {
    }

    public Volunteer(Long id, List<Skill> skills, boolean isAdmin) {
        Id = id;
        this.skills = skills;
        this.isAdmin = isAdmin;
    }

    public Volunteer(Long id, String name, String surname, String telephoneNumber, String email, Address address, Area area, String password, Long id1, List<Skill> skills, boolean isAdmin) {
        super(id, name, surname, telephoneNumber, email, address, area, password);
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
