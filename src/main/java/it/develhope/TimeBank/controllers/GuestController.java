package it.develhope.TimeBank.controllers;

//import it.develhope.TimeBank.entities.Address;
import it.develhope.TimeBank.entities.Guest;
import it.develhope.TimeBank.repository.GuestRepository;
import it.develhope.TimeBank.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private GuestService guestService;

    @PostMapping("/create")
    public ResponseEntity insertNewGuest(@RequestBody Guest guest){
       return guestService.createNewGuest(guest);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity <List<Guest>> getAllGuests() {
        return guestService.getAllGuests();
    }

    @GetMapping("/{nickname}")
    public ResponseEntity <Optional<Guest>> getGuestByNickname(@PathVariable String nickname) {
        return guestService.getGuestByNickname(nickname);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Guest> getGuestById(@PathVariable Long id) {
        return guestService.getGuestById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Guest guest){
         return guestService.updateGuest(id,guest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGuest(@PathVariable Long id){
       return guestService.deleteGuestById(id);
    }

    @DeleteMapping("/{nickname}")
    public ResponseEntity deleteGuestByNickname(@PathVariable String nickname) {
      return guestService.deleteGuestByNickname(nickname);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity delete(){
       return guestService.deleteAllGuests();
    }
}
