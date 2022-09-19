package it.develhope.TimeBank.controllers;

import io.swagger.annotations.ApiOperation;
import it.develhope.TimeBank.entities.Skill;
import it.develhope.TimeBank.repository.RequestRepository;
import it.develhope.TimeBank.entities.request.Request;
import it.develhope.TimeBank.repository.UserRepository;
import it.develhope.TimeBank.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
   @ApiOperation(value = "new request", notes = "create a new request")
   public ResponseEntity createRequest(@RequestBody Request request) throws Exception {
       try {
           return ResponseEntity.status(HttpStatus.OK).body(requestService.create(request));
       }catch(Exception ex){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
       }
   }

    @GetMapping("/fetchAll")
    @ApiOperation(value = "fetchAll", notes = "get all the request")
    public ResponseEntity getAllRequests() {
        try {
           return ResponseEntity.status(HttpStatus.OK).body(requestService.getAll());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "id", notes = "get request by id")
    public ResponseEntity getById(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(requestService.getById(id));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{skill}")
    @ApiOperation(value = "skill", notes = "get request by skill")
    public ResponseEntity getBySkill(@PathVariable Skill skill){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(requestService.getBySkill(skill));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "id", notes = "update request info by id")
    public ResponseEntity updateRequest(@PathVariable Long id, @RequestBody Request request){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(requestService.update(id,request));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "id", notes = "delete request by id")
    public ResponseEntity deleteById(@PathVariable Long id){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(requestService.deleteById(id));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{username}")
    @ApiOperation(value = "username", notes = "delete username's request")
    public ResponseEntity deleteRequestsByUsername(@PathVariable String username) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(requestService.deleteByUsername(username));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    @ApiOperation(value = "deleteAll", notes = "delete all the requests")
    public ResponseEntity deleteAllRequests(){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(requestService.deleteAll());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

}