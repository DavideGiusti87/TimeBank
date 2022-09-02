package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.entities.Address;
import it.develhope.TimeBank.entities.Guest;
import it.develhope.TimeBank.repository.GuestRepository;
import it.develhope.TimeBank.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private GuestService guestService;

    @PostMapping("/insertNewGuest")
    public void insertNewGuest(@RequestBody Guest guest){
        guestService.createNewGuest(guest);
    }

    @GetMapping("/getAll")
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }

    @GetMapping("/getByNickname")
    public Guest getGuestByNickname(@RequestParam String nickname) {
        return guestService.getGuestByNickname(nickname);
    }

    @GetMapping("/getById/{id}")
    public Guest getGuestById(@PathVariable Long id) {
        return guestService.getGuestById(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody Guest guest){
        guestService.updateGuest(id,guest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGuest(@PathVariable Long id){
        guestService.deleteGuestById(id);
    }

    @DeleteMapping("/delete/byNickname/{nickname}")
    public void deleteGuestByNickname(@PathVariable String nickname) {
       guestService.deleteGuestByNickname(nickname);
    }

    @DeleteMapping("/deleteAll")
    public void delete(){
        guestService.deleteAllGuests();
    }
}
