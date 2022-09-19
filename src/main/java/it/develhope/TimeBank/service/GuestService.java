package it.develhope.TimeBank.service;

import it.develhope.TimeBank.entities.Guest;
import it.develhope.TimeBank.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public Guest create(Guest guest) throws Exception{

        try {
            guest.setId(null);
            guestRepository.save(guest);
            return guestRepository.save(guest);
        }catch(Exception ex){
            throw new Exception("Bad input");
        }
    }

    public Guest updateGuest(Long id, Guest updatedGuest) throws Exception{

        if(!guestRepository.existsById(id)) {
            throw new Exception("Insert an existing Id");
        }
        return guestRepository.save(updatedGuest);
    }

    public List<Guest> getAllGuests() throws Exception{

        List<Guest> allGuestsList = guestRepository.findAll();
        if(allGuestsList.isEmpty()) {
            throw new Exception("The request list is empty");
        }
        return allGuestsList;
    }

    public Optional<Guest> getGuestById(Long id) throws Exception{
        try {
            Optional<Guest> guest = guestRepository.findById(id);
            return guest;
        }catch(Exception ex){
            throw new Exception("Id not found ");
        }
    }

    public Optional<Guest> getGuestByNickname(String nickname) throws Exception{
        try {
            Optional<Guest> guest = guestRepository.findByNickname(nickname);
            return guest;
        }catch(Exception ex){
            throw new Exception("Nickname not found ");
        }
    }

    public String deleteGuestById(Long id) throws Exception{

        try{
            if(guestRepository.existsById(id)){
                guestRepository.deleteById(id);
            }
        }catch(Exception ex){
            throw new Exception("Id not found");
        }
        return "Bad input";
    }

    public String deleteGuestByNickname(String nickname) throws Exception{

        try{
            if(guestRepository.existsByNickname(nickname)){
                guestRepository.deleteByNickname(nickname);
            }
        }catch(Exception ex){
            throw new Exception("Id not found");
        }
        return "Bad input";
    }


    public String deleteAllGuests() throws Exception{

        try{
            guestRepository.deleteAll();
        }catch(Exception ex){
            throw new Exception("Can not delete all");
        }
        return "Bad input";
    }
}
