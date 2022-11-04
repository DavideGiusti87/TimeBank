package it.develhope.TimeBank.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="requests")
public class Request extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;

    private boolean isAnonymous;
    // user is null if the request is anonymous
    @ManyToOne
    @JoinColumn(name="recipient_user_id")
    private User recipientUser;
    // If the request is anonymous these fields are provided into the RequestDTO,
    // otherwise are taken from the User.
    private String username;
    private String phoneNumber;
    private String email;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="area_id")
    private Area area;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Skill> requiredSkills;
    // sempre null al momento della creazione della richiesta; viene valorizzato al momento della presa in carico
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="volunteer_id")
    private User volunteer;

    public Request() {
    }

    public Request(String description, String title, boolean isAnonymous, User recipientUser, String username, String phoneNumber, String email, Area area, List<Skill> requiredSkills, User volunteer) {
        this.description = description;
        this.title = title;
        this.isAnonymous = isAnonymous;
        this.recipientUser = recipientUser;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.area = area;
        this.requiredSkills = requiredSkills;
        this.volunteer = volunteer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }

    public User getRecipientUser() {
        return recipientUser;
    }

    public void setRecipientUser(User recipientUser) {
        this.recipientUser = recipientUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Skill> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<Skill> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public User getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(User volunteer) {
        this.volunteer = volunteer;
    }

    /*
    se volunteer è null -> ritorna false (non c'è un volunteer, quindi non è presa in carico)
     */
    public boolean isTakenOver() {
        return volunteer != null;
    }

}
