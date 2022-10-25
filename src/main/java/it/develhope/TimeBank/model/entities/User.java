package it.develhope.TimeBank.model.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@Column(nullable = false)
    private String name;
    //@Column(nullable = false)
    private String surname;
    //@Column(nullable = false)
    private String username;
    //@Column(unique = true, nullable = false)

    private String password;
    private String telephoneNumber;
    //@Column(unique = true, nullable = false)
    private String email;
    //@Column(length = 36)
    private String activationCode;
    //@Column(length = 36)
    private String passwordResetCode;

    private LocalDateTime jwtCreatedOn;

    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;
    @ManyToMany
    private List<Skill> skills;
    @OneToMany(mappedBy = "volunteer")
    private List<Request> takenOverRequests;
    @OneToMany(mappedBy = "recipientUser")
    private List<Request> publishedRequests;

    /*
    Ogni volta che definisco una relazione devo definirla da entrambe le parti:
    - devo dire agli utenti che hanno una lista di ruoli
    - devo dire ai ruoli che hanno una lista di utenti
    */

    @ManyToMany/*(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "roles_user",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID") })*/
    private Set<Role> roles;


    public User() {
    }

    public User(Long id, String name, String surname, String username, String password, String telephoneNumber, String email, String activationCode, String passwordResetCode, LocalDateTime jwtCreatedOn, boolean isActive, Area area, List<Skill> skills, List<Request> takenOverRequests, List<Request> publishedRequests, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.activationCode = activationCode;
        this.passwordResetCode = passwordResetCode;
        this.jwtCreatedOn = jwtCreatedOn;
        this.isActive = isActive;
        this.area = area;
        this.skills = skills;
        this.takenOverRequests = takenOverRequests;
        this.publishedRequests = publishedRequests;
        this.roles = roles;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getPasswordResetCode() {
        return passwordResetCode;
    }

    public void setPasswordResetCode(String passwordResetCode) {
        this.passwordResetCode = passwordResetCode;
    }

    public LocalDateTime getJwtCreatedOn() {
        return jwtCreatedOn;
    }

    public void setJwtCreatedOn(LocalDateTime jwtCreatedOn) {
        this.jwtCreatedOn = jwtCreatedOn;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Request> getTakenOverRequests() {
        return takenOverRequests;
    }

    public void setTakenOverRequests(List<Request> takenOverRequests) {
        this.takenOverRequests = takenOverRequests;
    }

    public List<Request> getPublishedRequests() {
        return publishedRequests;
    }

    public void setPublishedRequests(List<Request> publishedRequests) {
        this.publishedRequests = publishedRequests;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
