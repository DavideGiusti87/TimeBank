package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.entities.Skill;
import it.develhope.TimeBank.repository.RequestRepository;
import it.develhope.TimeBank.entities.request.Request;
import it.develhope.TimeBank.repository.UserRepository;
import it.develhope.TimeBank.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requests")
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private RequestService requestService;
    @Autowired
    private UserRepository userRepository;

   @PostMapping("/new")
   public ResponseEntity createRequest(@RequestBody Request request) throws Exception {
       try {
           return ResponseEntity.status(HttpStatus.OK).body(requestService.create(request));
       }catch(Exception ex){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
       }
   }

    @GetMapping("/fetchAll")
    public ResponseEntity getAllRequests() {
        try {
           return ResponseEntity.status(HttpStatus.OK).body(requestService.getAll());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(requestService.getById(id));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{skill}")
    public ResponseEntity getBySkill(@PathVariable Skill skill){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(requestService.getBySkill(skill));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateRequest(@PathVariable Long id, @RequestBody Request request){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(requestService.update(id,request));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(requestService.deleteById(id));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{username}")
    public ResponseEntity deleteRequestsByUsername(@PathVariable String username) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(requestService.deleteByUsername(username));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAllRequests(){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(requestService.deleteAll());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}