package it.develhope.TimeBank.model.request;


import it.develhope.TimeBank.model.Area;
import it.develhope.TimeBank.model.Skill;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRequest {

    List<Skill> requiredSkill = new ArrayList<>();
    LocalDate localDate = LocalDate.now();
    Area area;
    private String title, description, name;
    private int phoneNumber;

    public AbstractRequest() {
    }

    public AbstractRequest(String title, String description, String name, int phoneNumber, List<Skill> requiredSkill, LocalDate localDate, Area area) {
        this.title = title;
        this.description = description;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.requiredSkill = requiredSkill;
        this.localDate = localDate;
        this.area = area;
    }

    //public void createRequest(){} <- ha un utilità ora che si fa tutto con spring? Se si quale?

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

    public List<Skill> getRequiredSkill() {
        return requiredSkill;
    }

    public void setRequiredSkill(List<Skill> requiredSkill) {
        this.requiredSkill = requiredSkill;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

}
