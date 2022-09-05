package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.entities.Skill;
import it.develhope.TimeBank.repository.RequestRepository;
import it.develhope.TimeBank.entities.request.Request;
import it.develhope.TimeBank.repository.UserRepository;
import it.develhope.TimeBank.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/getAll")
    public List<Request>getAllRequests() {
        return requestRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<Request> getById(@PathVariable Long id){
        return requestService.findById(id);
    }


    @GetMapping("/getBySkill/{skill}")
    public Optional<Request> getBySkill(@PathVariable Skill skill){
       return requestService.findBySkill(skill);
    }

    @PutMapping("/update/{id}")
    public void updateRequest(@PathVariable Long id, @RequestBody Request request){
       requestService.updateRequest(id, request);
    }


    @DeleteMapping("/delete/byUsername/{username}")
    public void deleteRequestsByUsername(@PathVariable String username) {
        requestService.deleteRequestsByUsername(username);
    }

    @DeleteMapping("/delete/byId/{id}")
    public void deleteById(@PathVariable Long id){
       requestRepository.deleteById(id);
    }

    @DeleteMapping("/delete/all")
    public void deleteAllRequests(){
       requestRepository.deleteAll();
    }

}