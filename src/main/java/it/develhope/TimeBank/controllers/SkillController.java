package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.entities.Skill;
import it.develhope.TimeBank.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private SkillsService skillsService;

    @PostMapping("/create")
    public ResponseEntity <Skill> create(@RequestBody Skill skill){
        return skillsService.create(skill);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity <List <Skill>> getAllSkills(){
      return skillsService.getAllSkills();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill> getASingleSkills(@PathVariable Long id){
       return skillsService.getASingleSkills(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Skill> update(@PathVariable Long id, @RequestBody @NonNull Skill skill) throws Exception {
        return skillsService.updateSkill(id, skill);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Skill> delete(@PathVariable Long id){
        return skillsService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Skill> deleteAll(){
        return skillsService.deleteAll();
    }

}
