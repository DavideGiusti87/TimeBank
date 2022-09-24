package it.develhope.TimeBank.controllers;

import io.swagger.annotations.ApiOperation;
import it.develhope.TimeBank.entities.Skill;
import it.develhope.TimeBank.repository.VolunteerRepository;
import it.develhope.TimeBank.service.VolunteerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/volunteer")
public class VolunteerController {

    @Autowired
    private VolunteerRepository volunteerRepository;
    @Autowired
    private VolunteerService volunteerService;

    private static final Logger logger = LoggerFactory.getLogger(VolunteerController.class);

    @GetMapping("/fetchAll")
    @ApiOperation(value = "fetchAll", notes = "get all users")
    public ResponseEntity getAllUsers() {

        try {
            logger.info("Get all Volunteers");
            return ResponseEntity.status(HttpStatus.OK).body(volunteerService.getAllVolunteers());
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{skill}")
    @ApiOperation(value = "skill", notes = "get volunteer by skill")
    public ResponseEntity getVolunteerBySkill(@PathVariable Skill skill) {

        try {
            logger.info("Get all Volunteers by Skill");
            return ResponseEntity.status(HttpStatus.OK).body(volunteerService.getVolunteerBySkill(skill));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
