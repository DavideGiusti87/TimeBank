package it.develhope.TimeBank.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="areas")
public class Area extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String region;
    private String town;
    private String neighborhood;

    @OneToMany(mappedBy = "area")
    private List<User> usersInThisArea;

    @OneToMany(mappedBy = "area")
    private List<Request> requestsInThisArea;

    public Area() {
    }

    public Area(Long id, String region, String town, String neighborhood) {
        this.id = id;
        this.region = region;
        this.town = town;
        this.neighborhood = neighborhood;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
