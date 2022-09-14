package it.develhope.TimeBank.controllers;

import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "create", notes = "creation of a new address")
    public ResponseEntity<Object> createAddress(@RequestBody Address address){
        return addressService.create(address);
    }

    @GetMapping("/fetchAll")
    @ApiOperation(value = "fetchAll", notes = "get the list of all address")
    public ResponseEntity <List<Address>> getAllAddress(){
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "id", notes = "get a single address")
    public ResponseEntity<Address> getSingleAddress(@PathVariable Long id){
        return addressService.getSingle(id);
    }
    @PutMapping("/{username}")
    public ResponseEntity<Address> update(@PathVariable Long id, @RequestBody Address address){
        return addressService.update(id, address);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "id", notes = "delete a single address")
    public ResponseEntity<Object> deleteSingleAddress(@PathVariable Long id){
        return addressService.deleteSingle(id);
    }

    @DeleteMapping("/deleteAll")
    @ApiOperation(value = "id", notes = "delete all address")
    public ResponseEntity<Object> delete(){
        return addressService.deleteAll();
    }
}
