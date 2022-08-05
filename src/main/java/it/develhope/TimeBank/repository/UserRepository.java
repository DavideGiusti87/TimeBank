package it.develhope.TimeBank.repository;

import it.develhope.TimeBank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
