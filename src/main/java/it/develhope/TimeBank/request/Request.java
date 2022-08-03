package it.develhope.TimeBank.request;

import it.develhope.TimeBank.Area;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

@Entity
@Table
public class Request extends AnonymousRequest{

    @Id
    private long id;

    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private Area area;

    public Request() {}

    public Request(String title, String description, String name, int phoneNumber) {
        super(title, description, name, phoneNumber);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
