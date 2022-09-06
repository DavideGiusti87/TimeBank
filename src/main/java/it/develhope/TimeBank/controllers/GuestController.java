package it.develhope.TimeBank.controllers;

//import it.develhope.TimeBank.entities.Address;
import it.develhope.TimeBank.entities.Guest;
import it.develhope.TimeBank.repository.GuestRepository;
import it.develhope.TimeBank.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void insertNewGuest(@RequestBody Guest guest){
        guestService.createNewGuest(guest);
    }

    @GetMapping("/fetchAll")
    public List<Guest> getAllGuests() {
        return (List<Guest>) guestService.getAllGuests();
    }

    @GetMapping("/{nickname}")
    public Optional<Guest> getGuestByNickname(@PathVariable String nickname) {
        return guestService.getGuestByNickname(nickname);
    }

    @GetMapping("/{id}")
    public Guest getGuestById(@PathVariable Long id) {
        return guestService.getGuestById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Guest guest){
        guestService.updateGuest(id,guest);
    }

    @DeleteMapping("/{id}")
    public void deleteGuest(@PathVariable Long id){
        guestService.deleteGuestById(id);
    }

    @DeleteMapping("/{nickname}")
    public void deleteGuestByNickname(@PathVariable String nickname) {
       guestService.deleteGuestByNickname(nickname);
    }

    @DeleteMapping("/deleteAll")
    public void delete(){
        guestService.deleteAllGuests();
    }
}
