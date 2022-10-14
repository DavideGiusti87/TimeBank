package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.model.DTO.SignupActivationDTO;
import it.develhope.TimeBank.model.DTO.SignupDTO;
import it.develhope.TimeBank.model.entities.User;
import it.develhope.TimeBank.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class SignupController {

    @Autowired
    private SignupService signupService;

    @PostMapping("/signup")
    public User signup(@RequestBody SignupDTO signupDTO) throws Exception {
        return signupService.signup(signupDTO);
    }

    @PostMapping("/signup/activation")
    public User activation(@RequestBody SignupActivationDTO signupActivationDTO) throws Exception {
        return signupService.activate(signupActivationDTO);

    }

    @PostMapping("/signup/{role}")
    public User signup(@RequestBody SignupDTO signupDTO, @PathVariable String role) throws Exception {
        return signupService.signup(signupDTO,role);
    }

}

