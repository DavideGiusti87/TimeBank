package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.exceptions.MissingAreaException;
import it.develhope.TimeBank.model.AnonymousRequestDTO;
import it.develhope.TimeBank.model.RequestDTO;
import it.develhope.TimeBank.model.Request;
import it.develhope.TimeBank.model.User;
import it.develhope.TimeBank.service.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
@RequestMapping("/requests")

public class RequestController {

    Logger logger = LoggerFactory.getLogger(RequestController.class);

    @Autowired
    RequestService requestService;

    @PostMapping("/createAnonymousRequest")
    public ResponseEntity createAnonymousRequest(@RequestBody AnonymousRequestDTO request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(requestService.createAnonymousRequest(request));
        } catch (Exception e) {
            logger.warn(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @PostMapping("/createNew")
    public ResponseEntity createNew(@RequestBody RequestDTO requestDTO, Principal principal) {
        try {
            User user = (User)((UsernamePasswordAuthenticationToken) principal).getPrincipal();
            Request newRequest = requestService.createNewRequest(requestDTO, user);
            return ResponseEntity.status(HttpStatus.OK).body(newRequest);
        } catch (Exception e) {
            logger.warn(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}