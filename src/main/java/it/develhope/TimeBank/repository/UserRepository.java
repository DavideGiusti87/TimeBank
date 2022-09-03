package it.develhope.TimeBank.repository;

import it.develhope.TimeBank.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getByName(String username);
    void deleteByUsername(String username);
}
