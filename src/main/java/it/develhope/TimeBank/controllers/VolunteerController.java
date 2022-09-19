package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.entities.Skill;
import it.develhope.TimeBank.entities.User;
import it.develhope.TimeBank.entities.Volunteer;
import it.develhope.TimeBank.repository.VolunteerRepository;
import it.develhope.TimeBank.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/volunteer")
public class VolunteerController {

    @Autowired
    private VolunteerRepository volunteerRepository;
    @Autowired
    private VolunteerService volunteerService;

    @GetMapping("/fetchAll")
    public ResponseEntity getAllUsers() {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(volunteerService.getAllVolunteers());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{skill}")
    public ResponseEntity getVolunteerBySkill(@PathVariable Skill skill) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(volunteerService.getVolunteerBySkill(skill));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
