package it.develhope.TimeBank.repository;


import it.develhope.TimeBank.model.Request;
import it.develhope.TimeBank.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    Optional<Request> findByVolunteerId(Long volunteer);

    Optional<Request> findByVolunteerIsNull();
}
