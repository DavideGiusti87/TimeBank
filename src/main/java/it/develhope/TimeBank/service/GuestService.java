package it.develhope.TimeBank.service;

import it.develhope.TimeBank.entities.Guest;
import it.develhope.TimeBank.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public void createNewGuest(Guest guest){
        guest.setId(null);
        guestRepository.save(guest);
    }

    public ResponseEntity <List<Guest>> getAllGuests() {

        List<Guest> allGuestsList = guestRepository.findAll();

        if(allGuestsList != null) {
            return new ResponseEntity(allGuestsList, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public Guest getGuestById(Long id) {
        Optional<Guest> guest = guestRepository.findById(id);
        return guest.get();
    }

    public Optional<Guest> getGuestByNickname(String nickname) {
        Optional<Guest> guest = guestRepository.findByNickname(nickname);
        return guest;
    }


    public ResponseEntity updateGuest(Long id, Guest updatedGuest) {
        if(!guestRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            guestRepository.save(updatedGuest);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }

    public void deleteGuestById(Long id) {
       guestRepository.deleteById(id);
    }

    public void deleteGuestByNickname(String nickname){}

    public void deleteAllGuests(){
        guestRepository.deleteAll();
    }
}
