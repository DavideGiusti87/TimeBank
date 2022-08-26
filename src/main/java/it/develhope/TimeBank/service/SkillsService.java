package it.develhope.TimeBank.service;

import it.develhope.TimeBank.entities.Skill;
import it.develhope.TimeBank.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SkillsService {

    @Autowired
    private SkillRepository skillRepository;

    public void create(Skill skill) {
        skillRepository.save(skill);
    }

    public List<Skill> getAllSkills() {
        List<Skill> allSkills = skillRepository.findAll();
        return allSkills;
    }

    public Skill getASingleSkills(Long id) {
        /**
         Qui usiamo optional con il IF
         */
        Optional<Skill> skill = skillRepository.findById(id);
        if (skill.isPresent()) {
            return skill.get();
        } else {
            return null;
        }
    }

    public Skill update(Long id, Skill skill) throws Exception {
        if(skillRepository.existsById(id)){
            return skillRepository.save(skill);
        }else{
            throw new Exception ("Id not found");
        }
    }

    public void delete(Long id){
        skillRepository.deleteById(id);
    }

    public void deleteAll(){
        skillRepository.deleteAll();
    }
}
