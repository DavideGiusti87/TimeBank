package it.develhope.TimeBank.repository;

import org.apache.coyote.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
