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

    public ResponseEntity insertNewUser (User user){
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

    public ResponseEntity <List<User>> getAllUsers() {

        List<User> allUsers = userRepository.findAll();
        if(allUsers !=null){
            //Terzo metodo di ritorno di ResponseEntity
            //Quale è meglio usare?
            return new ResponseEntity<>(allUsers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity <User> getUserById(Long Id) {
        try{
            Optional <User> user = userRepository.findById(Id);
            return new ResponseEntity<>(user.get(),HttpStatus.OK);
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity <User> getUserByUsername(String username) {
        try {
            Optional <User> user = userRepository.findByName(username);
            return new ResponseEntity<>(user.get(),HttpStatus.OK);
        }catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity updateUser(Long id, User updatedUser) {
        if(!userRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        userRepository.save(updatedUser);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity deleteUserByUsername(String username) {
        if(username == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        userRepository.deleteByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity deleteUserById(Long id) {
        if(id == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity deleteAllUsers(){
        userRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
