package it.develhope.TimeBank.repository;

import it.develhope.TimeBank.entities.Skill;
import it.develhope.TimeBank.entities.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VolunteerRepository extends JpaRepository <Volunteer,Long>{
    Optional<Volunteer> findBySkill(Skill skill);
}
