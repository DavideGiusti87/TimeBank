package it.develhope.TimeBank;

public class AnonymousRequest {
    private String name;
    private String description;


    public AnonymousRequest() {
    }

    public AnonymousRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
