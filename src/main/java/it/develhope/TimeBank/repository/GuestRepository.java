package it.develhope.TimeBank.repository;

import it.develhope.TimeBank.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository <Guest,Long> {

    Guest getByNickname(String nickname);

    void deleteByNickname(String nickname);
}
