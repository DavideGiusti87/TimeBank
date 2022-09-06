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
   public Request addRequest(@RequestBody Request request){
       return requestService.saveRequest(request);
   }

    @GetMapping("/fetchAll")
    public List<Request>getAllRequests() {
        return requestRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Request> getById(@PathVariable Long id){
        return requestRepository.findById(id);
    }

    @GetMapping("/{skill}")
    public Optional<Request> getBySkill(@PathVariable Skill skill){
       return requestRepository.findBySkill(skill);
    }

    @PutMapping("/{id}")
    public void updateRequest(@PathVariable Long id, @RequestBody Request request){
       requestService.updateRequest(id, request);
    }

    @DeleteMapping("/{username}")
    public void deleteRequestsByUsername(@PathVariable String username) {
        requestService.deleteRequestsByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
       requestRepository.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllRequests(){
       requestRepository.deleteAll();
    }

}