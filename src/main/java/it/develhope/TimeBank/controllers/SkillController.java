package it.develhope.TimeBank.controllers;

import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "create", notes = "creation of a new skill")
    public ResponseEntity<Skill> create(@RequestBody Skill skill){
        return skillsService.create(skill);
    }

    @GetMapping("/fetchAll")
    @ApiOperation(value = "fetchAll", notes = "get the list of the skills")
    public ResponseEntity <List <Skill>> getAllSkills(){
      return skillsService.getAllSkills();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "id", notes = "get a single skills")
    public ResponseEntity<Skill> getASingleSkills(@PathVariable Long id){
       return skillsService.getASingleSkills(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "id", notes = "update skill info by id")
    public ResponseEntity<Skill> update(@PathVariable Long id, @RequestBody @NonNull Skill skill) throws Exception {
        return skillsService.updateSkill(id, skill);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "id", notes = "delete skill by id")
    public ResponseEntity<Skill> delete(@PathVariable Long id){
        return skillsService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    @ApiOperation(value = "deleteAll", notes = "delete all the skills")
    public ResponseEntity<Skill> deleteAll(){
        return skillsService.deleteAll();
    }
}
