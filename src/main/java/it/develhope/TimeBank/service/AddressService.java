package it.develhope.TimeBank.service;

import it.develhope.TimeBank.entities.Address;
import it.develhope.TimeBank.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public void create(Address address){
        addressRepository.save(address);
    }
    public List<Address> getAll(){
        return addressRepository.findAll();
    }
    public Optional<Address> getSingle(Long id){
        return addressRepository.findById(id);
    }
    public void update(Long id, Address address){
        addressRepository.save(address);
    }
    public void deleteSingle(Long id){
        addressRepository.deleteById(id);
    }
    public void deleteAll(){
        addressRepository.deleteAll();
    }
}
