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

    public Address create(Address address) throws Exception {
        try{
            address.setId(null);
            addressRepository.save(address);
            return addressRepository.save(address);
        }catch(Exception ex){
            throw new Exception("Bad input");
        }
    }
    public Address update(Long id, Address address) throws Exception{

        if(!addressRepository.existsById(id)){
            throw new Exception("Insert an existing Id");
        }
        return addressRepository.save(address) ;
    }
    public List<Address> getAll() throws Exception{

        List<Address>address = addressRepository.findAll();
        if (address.isEmpty()){
            throw new Exception("The request list is empty");
        }else {
            return address;
        }

    }
    public Optional<Address> getById(Long id) throws Exception {
        try {
            Optional<Address> address = addressRepository.findById(id);
            return address;
        } catch (Exception ex){
            throw new Exception("Id not found ");
        }
    }

    public Address deleteAddressById(Long id) throws Exception{
        if(id == null){
            throw new Exception("Id not found");
        }
        return addressRepository.deleteById(id);;
    }
    public Address deleteAll() throws Exception{
        try {
            return addressRepository.deleteAll();
        }catch(Exception ex){
            throw new Exception("Can not delete All");
        }
    }
}