package it.develhope.TimeBank.controllers;

import io.swagger.annotations.ApiOperation;
import it.develhope.TimeBank.entities.User;
import it.develhope.TimeBank.repository.UserRepository;
import it.develhope.TimeBank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return userService.insertNewUser(user);
    }

    @GetMapping("/fetchAll")
    @ApiOperation(value = "fetchAll", notes = "get the list of all the users")
    public ResponseEntity <List<User>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "id", notes = "get user by id")
    public ResponseEntity <User> getUserById(@PathVariable Long Id) {
        return userService.getUserById(Id); }

    @GetMapping("/{username}")
    @ApiOperation(value = "username", notes = "get user by username")
    public ResponseEntity <User> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "id", notes = "update user info by id")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User updateUser) {
        return userService.updateUser(id, updateUser);
    }

    @DeleteMapping("/{username}")
    @ApiOperation(value = "username", notes = "delete user by username")
    public ResponseEntity deleteUserByUsername(@PathVariable String username) {
       return userService.deleteUserByUsername(username);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "id", notes = "delete user by by")
    public ResponseEntity deleteUserById(@PathVariable Long id) {
       return userService.deleteUserById(id);
    }

    @DeleteMapping("/deleteAll")
    @ApiOperation(value = "delete all", notes = "delete all users")
    public ResponseEntity deleteAll(){
        return userService.deleteAllUsers();
    }
}
