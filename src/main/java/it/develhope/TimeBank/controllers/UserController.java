package it.develhope.TimeBank.controllers;

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

    @PostMapping("/insertNewUser")
    public ResponseEntity insertNewUser(@RequestBody User user){
        return userService.insertNewUser(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUserByUsername")
    public User getUserByUsername(@RequestParam String username) {
        return userService.getUserByUsername(username);
    }


    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User updateUser){
        userService.updateUser(id, updateUser);
    }


    @DeleteMapping("/deleteUserByUsername")
    public void deleteUserByUsername(@RequestParam String username) {
        userService.deleteUserByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
