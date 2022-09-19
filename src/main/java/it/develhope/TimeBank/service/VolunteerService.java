package it.develhope.TimeBank.service;

import it.develhope.TimeBank.entities.Skill;
import it.develhope.TimeBank.entities.Volunteer;
import it.develhope.TimeBank.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerRepository volunteerRepository;

    public List<Volunteer> getAllVolunteers() throws Exception {

        List<Volunteer> allVolunteers = volunteerRepository.findAll();
        if (allVolunteers.isEmpty()) {
            throw new Exception("The Volunteer list is empty");
        }
        return allVolunteers;
    }

    public Optional<Volunteer> getVolunteerBySkill(Skill skill) throws Exception {
        try {
            Optional<Volunteer> volunteer = volunteerRepository.findBySkill(skill);
            return volunteer;
        } catch (Exception ex) {
            throw new Exception("The Volunteer skill not found ");
        }
    }
}
