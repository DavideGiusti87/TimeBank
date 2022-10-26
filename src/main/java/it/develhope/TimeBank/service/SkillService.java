package it.develhope.TimeBank.service;

import it.develhope.TimeBank.model.Skill;
import it.develhope.TimeBank.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

    @Autowired
    SkillRepository skillRepository;

    public Skill create(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill update(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill getASingleSkill(long id) throws Exception {
        Optional<Skill> optionalSkill = skillRepository.findById(id);
        if(optionalSkill.isPresent()) {
            return optionalSkill.get();
        }
        else {
            throw new Exception("Skill not found");
        }
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }


}
