package it.develhope.TimeBank.repository;

import it.develhope.TimeBank.entities.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteerRepository extends JpaRepository <Volunteer,Long>{
}
