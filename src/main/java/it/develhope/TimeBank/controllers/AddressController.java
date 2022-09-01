package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.entities.Address;
import it.develhope.TimeBank.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/new")
    public void createAddress(@RequestBody Address address){
        addressService.create(address);
    }

    @GetMapping("/getAll")
    public List<Address> getAllAddress(){
        return addressService.getAll();
    }

    @GetMapping("/getSingle/{id}")
    public Optional<Address> getSingleAddress(@PathVariable Long id){
        return Optional.ofNullable(addressService.getSingle(id).orElse(null));
    }
    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody Address address){
        addressService.update(id,address);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSingleAddress(@PathVariable Long id){
        addressService.deleteSingle(id);
    }

    @DeleteMapping("/delete")
    public void delete(){
        addressService.deleteAll();
    }
}
