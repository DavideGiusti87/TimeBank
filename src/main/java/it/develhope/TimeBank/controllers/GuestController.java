package it.develhope.TimeBank.controllers;

//import it.develhope.TimeBank.entities.Address;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "create", notes = "creation of a new guess")
    public ResponseEntity insertNewGuest(@RequestBody Guest guest){
       return guestService.createNewGuest(guest);
    }

    @GetMapping("/fetchAll")
    @ApiOperation(value = "fetchAll", notes = "get all the guests")
    public ResponseEntity <List<Guest>> getAllGuests() {
        return guestService.getAllGuests();
    }

    @GetMapping("/{nickname}")
    @ApiOperation(value = "nickname", notes = "get all the guests by nickname")
    public ResponseEntity <Optional<Guest>> getGuestByNickname(@PathVariable String nickname) {
        return guestService.getGuestByNickname(nickname);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "id", notes = "get guest by id")
    public ResponseEntity <Guest> getGuestById(@PathVariable Long id) {
        return guestService.getGuestById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "id", notes = "update guest info by id")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Guest guest){
         return guestService.updateGuest(id,guest);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "id", notes = "delete guest by id")
    public ResponseEntity deleteGuest(@PathVariable Long id){
       return guestService.deleteGuestById(id);
    }

    @DeleteMapping("/{nickname}")
    @ApiOperation(value = "id", notes = "delete guest by nickname")
    public ResponseEntity deleteGuestByNickname(@PathVariable String nickname) {
      return guestService.deleteGuestByNickname(nickname);
    }

    @DeleteMapping("/deleteAll")
    @ApiOperation(value = "id", notes = "delete all guests")
    public ResponseEntity delete(){
       return guestService.deleteAllGuests();
    }
}
