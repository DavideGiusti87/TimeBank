package it.develhope.TimeBank.controllers;

import io.swagger.annotations.ApiOperation;
import it.develhope.TimeBank.entities.Address;
import it.develhope.TimeBank.repository.AddressRepository;
import it.develhope.TimeBank.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("/create")
    @ApiOperation(value = "create", notes = "creation of a new address")
    public ResponseEntity createAddress(@RequestBody Address address){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(addressService.create(address));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "id", notes = "get a single address")
        public ResponseEntity getSingleAddress(@PathVariable Long id){
            try {
                return ResponseEntity.status(HttpStatus.OK).body(addressService.getById(id));
            }catch(Exception ex){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
            }
        }
    @PutMapping("/{username}")
    @ApiOperation(value = "username", notes = "Update the name")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Address address){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(addressService.update(id,address));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
    @GetMapping("/fetchAll")
    @ApiOperation(value = "fetchAll", notes = "get the list of all address")
    public ResponseEntity getAllAddress(){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(addressService.getAll());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "id", notes = "delete a single address")
    public ResponseEntity deleteBySingleId(@PathVariable Long id){

            try {
                return ResponseEntity.status(HttpStatus.OK).body(addressService.deleteAddressById(id));
            }catch(Exception ex){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
            }
        }

    @DeleteMapping("/deleteAll")
    @ApiOperation(value = "id", notes = "delete all address")
    public ResponseEntity deleteAll(){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(addressService.deleteAll());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
