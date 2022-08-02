package it.develhope.TimeBank.request;

public class AnonymousRequest {

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
