package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.model.Skill;
import it.develhope.TimeBank.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @GetMapping
    public List<Skill> displaySkills(){
        return new ArrayList<>();
    }
}
