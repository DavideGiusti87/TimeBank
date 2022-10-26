package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.exceptions.MissingAreaException;
import it.develhope.TimeBank.model.RequestDTO;
import it.develhope.TimeBank.model.Request;
import it.develhope.TimeBank.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requests")
public class RequestController {

    @Autowired
    RequestService requestService;

    @PostMapping("/createNew")
    public ResponseEntity createNew(@RequestBody RequestDTO requestDTO) {
        try {
            Request newRequest = requestService.createNewRequest(requestDTO);
            return ResponseEntity.status(HttpStatus.OK).body(newRequest);
            // TODO Other exceptions

        } catch (MissingAreaException e) {
            // TODO Logger
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}