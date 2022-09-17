package it.develhope.TimeBank.controllers;

//import it.develhope.TimeBank.entities.Address;
import it.develhope.TimeBank.entities.Guest;
import it.develhope.TimeBank.repository.GuestRepository;
import it.develhope.TimeBank.service.GuestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    private static Logger logger = LoggerFactory.getLogger(GuestController.class);

    @PostMapping("/create")
    public ResponseEntity insertNewGuest(@RequestBody Guest guest){
        try {
            logger.info("creation of a guess");
            return ResponseEntity.status(HttpStatus.OK).body(guestService.create(guest));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Guest guest){
        try {
            logger.info("update guess info");
            return ResponseEntity.status(HttpStatus.OK).body(guestService.updateGuest(id,guest));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/fetchAll")
    public ResponseEntity getAllGuests() {
        try {
            logger.info("get all guests");
            return ResponseEntity.status(HttpStatus.OK).body(guestService.getAllGuests());
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getGuestById(@PathVariable Long id) {
        try {
            logger.info("get a single guest by id");
            return ResponseEntity.status(HttpStatus.OK).body(guestService.getGuestById(id));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{nickname}")
    public ResponseEntity getGuestByNickname(@PathVariable String nickname) {
        try {
            logger.info("get a guest by nickname");
            return ResponseEntity.status(HttpStatus.OK).body(guestService.getGuestByNickname(nickname));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGuest(@PathVariable Long id){
        try {
            logger.info("delete guest by id");
            return ResponseEntity.status(HttpStatus.OK).body(guestService.deleteGuestById(id));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{nickname}")
    public ResponseEntity deleteGuestByNickname(@PathVariable String nickname) {
        try {
            logger.info("delete guest by nickname");
            return ResponseEntity.status(HttpStatus.OK).body(guestService.deleteGuestByNickname(nickname));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity delete(){
        try {
            logger.info("delete all guests");
            return ResponseEntity.status(HttpStatus.OK).body(guestService.deleteAllGuests());
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
