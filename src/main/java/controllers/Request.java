package controllers;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Request {

    private User<> details;
    //qui immagino ci da una lista coi dati del user: nome, telefono, email
    private String description;
    private Skill skill;
    private Area area;
    private String address;
}
