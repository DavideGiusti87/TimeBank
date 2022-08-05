package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This controller has to provide all the main operations we need on the User class.
 * The main operations we need are the CRUD (Create, Read, Update, Delete) operations.
 */


@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/insertNewUser")
    public void insertNewUser(@RequestBody User user) {
        // TODO API for insert a new User into the Database
        // TODO return an HTTP Response with the exit of the operation
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        // TODO API for fetching the list of all users
        return new ArrayList<>();
    }

    @GetMapping("/getUserByUsername")
    public User getUserByUsername(@RequestParam String username) {
        // TODO API for fetching a single user by username
        return new User();
    }


    @PutMapping("/updateUser")
    public void updateUser(@RequestBody User updatedUser) {
        // TODO API for updating User's informations
        // TODO return an HTTP Response with the exit of the operation
    }


    @DeleteMapping("/deleteUserByUsername")
    public void deleteUserByUsername(@RequestParam String username) {
        // TODO API for deleting a User by username
        // TODO return an HTTP Response with the exit of the operation

    }

    @DeleteMapping("/deleteUserById")
    public void deleteUserById(@RequestParam int id) {
        // TODO API for deleting a User by id
        // TODO return an HTTP Response with the exit of the operation
    }

}
