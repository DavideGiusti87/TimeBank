package it.develhope.TimeBank.service;

import it.develhope.TimeBank.entities.Skill;
import it.develhope.TimeBank.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class SkillsService {

    @Autowired
    private SkillRepository skillRepository;

    public ResponseEntity<Skill> create(Skill skill) {
        try {
            skill.setId(null);
            skillRepository.save(skill);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<List<Skill>> getAllSkills() {
        List<Skill> allSkills = skillRepository.findAll();
        if(allSkills != null){
            return new ResponseEntity<>(allSkills, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Skill> getASingleSkills(Long id) {
        try {
            Optional<Skill> skill = skillRepository.findById(id);
            return new ResponseEntity<>(skill.get(), HttpStatus.OK);
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    public ResponseEntity<Skill> updateSkill(Long id, Skill skill) {
        if(!skillRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        skillRepository.save(skill);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity<Skill> deleteById (@RequestParam Long id){
        if(id == null){
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        skillRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity<Skill> deleteAll(){
        skillRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
