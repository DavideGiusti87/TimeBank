package it.develhope.TimeBank.controllers;

import io.swagger.annotations.ApiOperation;
import it.develhope.TimeBank.entities.User;
import it.develhope.TimeBank.repository.UserRepository;
import it.develhope.TimeBank.service.UserService;
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

    @PostMapping("/create")
    @ApiOperation(value = "create", notes = "creation of a new user")
    public ResponseEntity insertNewUser(@RequestBody User user){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.createNewUser(user));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "id", notes = "update user info by id")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User updateUser) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id,updateUser));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/fetchAll")
    @ApiOperation(value = "fetchAll", notes = "get the list of all the users")
    public ResponseEntity getAllUsers() {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "id", notes = "get user by id")
    public ResponseEntity getUserById(@PathVariable Long id) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{username}")
    @ApiOperation(value = "username", notes = "get user by username")
    public ResponseEntity getUserByUsername(@PathVariable String username) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByUsername(username));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "id", notes = "delete user by by")
    public ResponseEntity deleteUserById(@PathVariable Long id) throws Exception {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUserById(id));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{username}")
    @ApiOperation(value = "username", notes = "delete user by username")
    public ResponseEntity deleteUserByUsername(@PathVariable String username) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUserByUsername(username));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    @ApiOperation(value = "delete all", notes = "delete all users")
    public ResponseEntity deleteAll(){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.deleteAllUsers());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
