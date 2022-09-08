package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.entities.Skill;
import it.develhope.TimeBank.entities.User;
import it.develhope.TimeBank.entities.Volunteer;
import it.develhope.TimeBank.repository.VolunteerRepository;
import it.develhope.TimeBank.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<Volunteer>> getAllUsers() {
        return volunteerService.getAllVolunteers();
    }

    @GetMapping("/{skill}")
    public ResponseEntity<Volunteer> getVolunteerBySkill(@PathVariable Skill skill) {
        return volunteerService.getVolunteerBySkill(skill);
    }

}
