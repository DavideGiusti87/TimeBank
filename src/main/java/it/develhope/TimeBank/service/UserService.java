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

    public User createNewUser (User user) throws Exception{
        try{
            user.setId(null);
            userRepository.save(user);
            //Primo metodo di ritorno di ResponseEntity
            return userRepository.save(user); }
        catch(Exception ex){
            //Secondo metodo di ritorno di ResponseEntity;
            throw new Exception("Bad input");
        }
    }

    public User updateUser(Long id, User updatedUser) throws Exception{

        if(!userRepository.existsById(id)) {
            throw new Exception("Insert an existing Id");
        }
        return userRepository.save(updatedUser);
    }

    public List<User> getAllUsers() throws Exception{

        List<User> allUsers = userRepository.findAll();
        if(allUsers.isEmpty()){
            throw new Exception("The Skill list is empty");
        }
        return allUsers;

    }

    public Optional<User> getUserById(Long Id) throws Exception{

        try{
            Optional <User> user = userRepository.findById(Id);
            return user;
        } catch(Exception ex){
            throw new Exception("Id not found ");
        }
    }

    public Optional<User> getUserByUsername(String username) throws Exception{

        try {
            Optional <User> user = userRepository.findByName(username);
            return user;
        }catch(Exception ex) {
           throw new Exception("Username not found");
        }
    }

    public User deleteUserByUsername(String username) throws Exception{

        try{
            return userRepository.deleteByUsername(username);
        }catch(Exception ex){
            throw new Exception("Username not found");
        }
    }

    public String deleteUserById(Long id) throws Exception{

        try{
            if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "The user with id: " + id + " got deleted";
            }
        }catch(Exception ex){
            throw new Exception("Id not found");
        }
        return "User not found";
    }

    public String deleteAllUsers() throws Exception{

        try{
            userRepository.deleteAll();
            return "All users got deleted";
        }catch(Exception ex){
            throw new Exception("Bad request");
        }
    }
}
