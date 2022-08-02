package it.develhope.TimeBank.controller;

import it.develhope.TimeBank.entities.AnonymousRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelpRequestController {

    @GetMapping("/getAllRequests")
    public List<AnonymousRequest> getAllRequests() {
        List<AnonymousRequest> requests = new ArrayList<>();
        requests.add(new AnonymousRequest("Request title", "Request description", "Name", 123456789));
        requests.add(new AnonymousRequest("Request title2", "Request description2", "Name2", 987654321));
        return requests;
    }

}