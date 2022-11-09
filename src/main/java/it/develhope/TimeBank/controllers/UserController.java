package it.develhope.TimeBank.controllers;

import io.swagger.annotations.ApiOperation;
import it.develhope.TimeBank.model.User;
import it.develhope.TimeBank.repository.UserRepository;
import it.develhope.TimeBank.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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

    @PreAuthorize("hasRole('ROLE_REGISTERED') or hasRole('ROLE_ADMIN')")
    @PutMapping("/update")
    @ApiOperation(value = "principal", notes = "update user info by principal")
    public ResponseEntity updateUser(@RequestBody User updatedUser, Principal principal) {

        try {
            logger.info("Edit a User");
            User user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
            return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(user, updatedUser));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_REGISTERED') or hasRole('ROLE_ADMIN')")
    @GetMapping("/fetchAll")
    @ApiOperation(value = "fetchAll", notes = "get the list of all the users")
    public ResponseEntity getAllUsers() {

        try {
            logger.info("Get all users");
            return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_REGISTERED') or hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    @ApiOperation(value = "id", notes = "get user by id")
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
    @ApiOperation(value = "username", notes = "get user by username")
    public ResponseEntity getUserByUsername(@PathVariable String username) {

        try {
            logger.info("Get User by username");
            return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByUsername(username));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_REGISTERED') or hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete")
    @ApiOperation(value = "principal", notes = "delete user by principal")
    public ResponseEntity deleteUserById(Principal principal){

        try {
            logger.info("Delete logged user");
            User user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
            return ResponseEntity.status(HttpStatus.OK).body(userService.deleteById(user.getId()));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}