package it.develhope.TimeBank.repository;

import it.develhope.TimeBank.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository <Guest,Long> {

    Optional <Guest> findByNickname(String nickname);

    void deleteByNickname(String nickname);

    boolean existsByNickname(String nickname);
}
