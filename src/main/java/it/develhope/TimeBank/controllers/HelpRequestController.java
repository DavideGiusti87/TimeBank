package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.repository.RequestRepository;
import it.develhope.TimeBank.model.request.AnonymousRequest;
import it.develhope.TimeBank.model.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelpRequestController {
    @Autowired
    private RequestRepository requestRepository;

   /* @PostMapping("")
    public Request createRequest(@RequestBody Request request){
        request.setEmail(null);
        request.setArea(null);
        request.setId(100);
        return requestRepository.save(request);
    }*/

    @GetMapping("/getAllRequests")
    public List<AnonymousRequest> getAllRequests() {
        List<AnonymousRequest> requests = new ArrayList<>();
        requests.add(new AnonymousRequest("Request title", "Request description", "Name", 123456789));
        requests.add(new AnonymousRequest("Request title2", "Request description2", "Name2", 987654321));
        return requests;
    }

    @GetMapping("/area/{s}")
    public List<Request> getArea(@PathVariable String s){
        List<Request> byArea = new ArrayList<>();
        return byArea;
    }

    @GetMapping("/skill/{s}")
    public List<Request> getSkill(@PathVariable String s){
        List<Request> bySkill = new ArrayList<>();
        return bySkill;
    }
}