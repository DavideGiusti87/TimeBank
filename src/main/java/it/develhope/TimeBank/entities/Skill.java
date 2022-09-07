package it.develhope.TimeBank.entities;


import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @ApiModelProperty(value = "Id", notes = "Id of Skill")
    private Long id;
    @ApiModelProperty(value = "name", notes = "name of Skill")
    private String name;
    @ApiModelProperty(value = "description", notes = "description of Skill")
    private String description;

    public Skill() {
    }

    public Skill(Long id, String description, String name) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
