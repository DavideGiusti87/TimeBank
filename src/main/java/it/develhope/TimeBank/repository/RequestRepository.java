package it.develhope.TimeBank.repository;

import it.develhope.TimeBank.model.request.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
