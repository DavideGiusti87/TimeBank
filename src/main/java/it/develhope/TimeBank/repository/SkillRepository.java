package it.develhope.TimeBank.repository;

import it.develhope.TimeBank.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    public Optional<Skill> findByName(String name);

}
