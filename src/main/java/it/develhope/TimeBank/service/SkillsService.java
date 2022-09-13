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

    public Skill create(Skill skill) throws Exception{
        try {
            skill.setId(null);
            return skillRepository.save(skill);
        }catch (Exception ex){
            throw new Exception("Bad input");
        }
    }

    public Skill updateSkill(Long id, Skill skill) throws Exception{

        if(!skillRepository.existsById(id)){
            throw new Exception("Insert an existing Id");
        }
        return  skillRepository.save(skill);
    }
    public List<Skill> getAllSkills() throws Exception{

        List<Skill> allSkills = skillRepository.findAll();
        if(allSkills.isEmpty()){
            throw new Exception("The Skill list is empty");
        }
        return allSkills;
    }

    public Optional<Skill> getASingleSkill(Long id) throws Exception{

        try {
            Optional<Skill> skill = skillRepository.findById(id);
            return skill;
        } catch (Exception ex){
            throw new Exception("Id not found ");
        }
    }

    public Skill deleteById (@RequestParam Long id) throws Exception{

        try{
            if(skillRepository.existsById(id)) {
               return skillRepository.deleteById(id);
            }
        }catch(Exception ex){
            throw new Exception("Id not fund");
        }
    }

    public Skill deleteAll() throws Exception{
        try {
            return skillRepository.deleteAll();
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
}
