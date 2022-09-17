package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.entities.User;
import it.develhope.TimeBank.repository.UserRepository;
import it.develhope.TimeBank.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller has to provide all the main operations we need on the User class.
 * The main operations we need are the CRUD (Create, Read, Update, Delete) operations.
 */


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/create")
    public ResponseEntity insertNewUser(@RequestBody User user){

        try {
            logger.info("Insert a new User");
            return ResponseEntity.status(HttpStatus.OK).body(userService.createNewUser(user));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User updateUser) {

        try {
            logger.info("Edit a User");
            return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id,updateUser));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/fetchAll")
    public ResponseEntity getAllUsers() {

        try {
            logger.info("Get all User");
            return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Long id) {

        try {
            logger.info("Get User by id");
            return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity getUserByUsername(@PathVariable String username) {

        try {
            logger.info("Get User by username");
            return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByUsername(username));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@PathVariable Long id) throws Exception {

        try {
            logger.info("Delete User by id");
            return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUserById(id));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{username}")
    public ResponseEntity deleteUserByUsername(@PathVariable String username) {

        try {
            logger.info("Delete User by username");
            return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUserByUsername(username));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAll(){

        try {
            logger.info("Delete all User");
            return ResponseEntity.status(HttpStatus.OK).body(userService.deleteAllUsers());
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
