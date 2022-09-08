package it.develhope.TimeBank.service;

import it.develhope.TimeBank.entities.Skill;
import it.develhope.TimeBank.entities.User;
import it.develhope.TimeBank.entities.Volunteer;
import it.develhope.TimeBank.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerRepository volunteerRepository;

    public ResponseEntity<List<Volunteer>> getAllVolunteers() {
        try{
            List<Volunteer> allVolunteers = volunteerRepository.findAll();
            return new ResponseEntity<>(allVolunteers, HttpStatus.OK);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    public ResponseEntity<Volunteer> getVolunteerBySkill(Skill skill) {
        try{
            Optional<Volunteer> volunteer = volunteerRepository.findBySkill(skill);
            return new ResponseEntity<>(volunteer.get(), HttpStatus.OK);
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

}
