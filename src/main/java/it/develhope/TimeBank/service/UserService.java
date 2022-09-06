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

    public ResponseEntity insertNewUser(User user){
        user.setId(null);
        userRepository.save(user);
        //return an HTTP Response with the exit of the operation
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public List<User> getAllUsers() {
        //API for fetching the list of all users
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    public User getUserByUsername(String username) {
        //API for fetching a single user by username
        /**
         * Qui usiamo optional senza il IF
          */
        Optional<User> user = userRepository.findByName(username);
            return user.get();
    }


    public ResponseEntity updateUser(Long id, User updatedUser) {
        // API for updating User's informations
        // return an HTTP Response with the exit of the operation
        if(!userRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            userRepository.save(updatedUser);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }

    public ResponseEntity deleteUserByUsername(String username) {
        // API for deleting a User by username
        // return an HTTP Response with the exit of the operation
        userRepository.deleteByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/deleteUserById")
    public ResponseEntity deleteUserById(@RequestParam Long id) {
        //API for deleting a User by id
        //return an HTTP Response with the exit of the operation
        userRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
