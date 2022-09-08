package it.develhope.TimeBank.repository;

import it.develhope.TimeBank.entities.Skill;
import it.develhope.TimeBank.entities.request.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {


    void deleteByUsername(String username);

    Optional<Request> findBySkill(Skill skill);
}
