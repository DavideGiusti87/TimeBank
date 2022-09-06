package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.entities.Skill;
import it.develhope.TimeBank.repository.RequestRepository;
import it.develhope.TimeBank.entities.request.Request;
import it.develhope.TimeBank.repository.UserRepository;
import it.develhope.TimeBank.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
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
   public ResponseEntity<Request> addRequest(@RequestBody Request request){
       return requestService.createRequest(request);
   }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<Request>> getAllRequests() {
        return requestService.getAllRequests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> getById(@PathVariable Long id){
        return requestService.getRequestById(id);
    }

    @GetMapping("/{skill}")
    public ResponseEntity<Request> getBySkill(@PathVariable Skill skill){
       return requestService.getRequestBySkill(skill);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Request> updateRequest(@PathVariable Long id, @RequestBody Request request){
       return requestService.updateRequest(id, request);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Request> deleteRequestsByUsername(@PathVariable String username) {
        return requestService.deleteByUsername(username);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Request> deleteById(@PathVariable Long id){
       return requestService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Request> deleteAllRequests(){
       return requestService.deleteAll();
    }

}