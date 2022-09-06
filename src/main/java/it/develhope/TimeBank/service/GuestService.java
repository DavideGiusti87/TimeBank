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

    public ResponseEntity createNewGuest(Guest guest){
        try{
            guest.setId(null);
            guestRepository.save(guest);
            return ResponseEntity.status(HttpStatus.OK).build();}
        catch(Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity <List<Guest>> getAllGuests() {

        List<Guest> allGuestsList = guestRepository.findAll();

        if(allGuestsList != null) {
            return new ResponseEntity(allGuestsList, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity <Guest> getGuestById(Long id) {
        try{
            Optional<Guest> guest = guestRepository.findById(id);
            return new ResponseEntity<>(guest.get(),HttpStatus.OK);}
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity <Optional<Guest>> getGuestByNickname(String nickname) {
        try {
            Optional<Guest> guest = guestRepository.findByNickname(nickname);
            return new ResponseEntity<>(guest,HttpStatus.OK);
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity updateGuest(Long id, Guest updatedGuest) {
        if(!guestRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
            guestRepository.save(updatedGuest);
            return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity deleteGuestById(Long id) {
        if(id == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        guestRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity deleteGuestByNickname(String nickname){
        if(nickname == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        guestRepository.deleteByNickname(nickname);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity deleteAllGuests(){
        guestRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
