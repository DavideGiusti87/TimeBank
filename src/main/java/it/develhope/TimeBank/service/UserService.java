package it.develhope.TimeBank.service;

import it.develhope.TimeBank.entities.User;
import it.develhope.TimeBank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User insertNewUser (User user) throws Exception{
        try{
            user.setId(null);
            userRepository.save(user);
            //Primo metodo di ritorno di ResponseEntity
            return ResponseEntity.status(HttpStatus.OK).build();}
        catch(Exception ex){
            //Secondo metodo di ritorno di ResponseEntity
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public List<User> getAllUsers() throws Exception{

        List<User> allUsers = userRepository.findAll();
        if(allUsers !=null){
            //Terzo metodo di ritorno di ResponseEntity
            //Quale è meglio usare?
            return new ResponseEntity<>(allUsers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public User getUserById(Long Id) throws Exception{
        try{
            Optional <User> user = userRepository.findById(Id);
            return new ResponseEntity<>(user.get(),HttpStatus.OK);
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public User getUserByUsername(String username) throws Exception{
        try {
            Optional <User> user = userRepository.findByName(username);
            return new ResponseEntity<>(user.get(),HttpStatus.OK);
        }catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public User updateUser(Long id, User updatedUser) throws Exception{
        if(!userRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        userRepository.save(updatedUser);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public User deleteUserByUsername(String username) throws Exception{
        if(username == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        userRepository.deleteByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public User deleteUserById(Long id) throws Exception{
        if(id == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public User deleteAllUsers() throws Exception{
        userRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
