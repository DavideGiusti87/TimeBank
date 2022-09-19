package it.develhope.TimeBank.controllers;

//import it.develhope.TimeBank.entities.Address;
import io.swagger.annotations.ApiOperation;
import it.develhope.TimeBank.entities.Guest;
import it.develhope.TimeBank.repository.GuestRepository;
import it.develhope.TimeBank.service.GuestService;
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

    @PostMapping("/create")
    @ApiOperation(value = "create", notes = "creation of a new guess")
    public ResponseEntity insertNewGuest(@RequestBody Guest guest){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(guestService.create(guest));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "id", notes = "update guest info by id")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Guest guest){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(guestService.updateGuest(id,guest));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/fetchAll")
    @ApiOperation(value = "fetchAll", notes = "get all the guests")
    public ResponseEntity getAllGuests() {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(guestService.getAllGuests());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "id", notes = "get guest by id")
    public ResponseEntity getGuestById(@PathVariable Long id) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(guestService.getGuestById(id));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{nickname}")
    @ApiOperation(value = "nickname", notes = "get all the guests by nickname")
    public ResponseEntity getGuestByNickname(@PathVariable String nickname) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(guestService.getGuestByNickname(nickname));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "id", notes = "delete guest by id")
    public ResponseEntity deleteGuest(@PathVariable Long id){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(guestService.deleteGuestById(id));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{nickname}")
    @ApiOperation(value = "id", notes = "delete guest by nickname")
    public ResponseEntity deleteGuestByNickname(@PathVariable String nickname) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(guestService.deleteGuestByNickname(nickname));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    @ApiOperation(value = "id", notes = "delete all guests")
    public ResponseEntity delete(){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(guestService.deleteAllGuests());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
