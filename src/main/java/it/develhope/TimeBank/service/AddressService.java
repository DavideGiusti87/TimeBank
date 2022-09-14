package it.develhope.TimeBank.service;

import it.develhope.TimeBank.entities.Address;
import it.develhope.TimeBank.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public ResponseEntity<Object> create(Address address){
        try{
            address.setId(null);
            addressRepository.save(address);
            return ResponseEntity.status(HttpStatus.OK).build();}
        catch(Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
    public ResponseEntity<List<Address>> getAll(){
        List<Address>address = addressRepository.findAll();
        if (!address.isEmpty()){
            return new ResponseEntity<List<Address>>(address, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<Address> getSingle(Long id){
        try{
            Optional <Address> address = addressRepository.findById(id);
            return new ResponseEntity<>(address.get(),HttpStatus.OK);
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    public ResponseEntity<Address> update(Long id, Address address){
        if(!addressRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        addressRepository.save(address);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity<Object> deleteSingle(Long id){
        if(id == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        addressRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    public ResponseEntity<Object> deleteAll(){
        addressRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}