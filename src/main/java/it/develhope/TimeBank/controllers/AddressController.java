package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.entities.Address;
import it.develhope.TimeBank.repository.AddressRepository;
import it.develhope.TimeBank.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Object> createAddress(@RequestBody Address address){
        return addressService.create(address);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity <List<Address>> getAllAddress(){
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getSingleAddress(@PathVariable Long id){
        return addressService.getSingle(id);
    }
    @PutMapping("/{username}")
    public ResponseEntity<Address> update(@PathVariable Long id, @RequestBody Address address){
        return addressService.update(id, address);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSingleAddress(@PathVariable Long id){
        return addressService.deleteSingle(id);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Object> delete(){
        return addressService.deleteAll();
    }
}
