package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.entities.Skill;
import it.develhope.TimeBank.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private SkillsService skillsService;

    @PostMapping("/create")
    public void create(@RequestBody Skill skill){skillsService.create(skill);}

    @GetMapping("/fetchAll")
    public List <Skill> getAllSkills(){
      return skillsService.getAllSkills();
    }

    @GetMapping("/{id}")
    public Skill getASingleSkills(@PathVariable Long id){
       return skillsService.getASingleSkills(id);
    }

    @PutMapping("/{id}")
    public Skill update(@PathVariable Long id, @RequestBody @NonNull Skill skill) throws Exception {
        return skillsService.update(id, skill);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        skillsService.delete(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        skillsService.deleteAll();
    }

}
