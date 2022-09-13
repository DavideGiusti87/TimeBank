package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.entities.Skill;
import it.develhope.TimeBank.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity create(@RequestBody Skill skill){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(skillsService.create(skill));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody @NonNull Skill skill) throws Exception{

        try {
            return ResponseEntity.status(HttpStatus.OK).body(skillsService.updateSkill(id,skill));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getASingleSkills(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(skillsService.getASingleSkill(id));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/fetchAll")
    public ResponseEntity getAllSkills(){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(skillsService.getAllSkills());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(skillsService.deleteById(id));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAll(){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(skillsService.deleteAll());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
