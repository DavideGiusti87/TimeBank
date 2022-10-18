package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.model.DTO.SignupActivationDTO;
import it.develhope.TimeBank.model.DTO.SignupDTO;
import it.develhope.TimeBank.model.entities.User;
import it.develhope.TimeBank.service.SignupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(SignupController.class);

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody SignupDTO signupDTO) /*throws Exception */{
        try {
            logger.info("Registration successful!");
            return ResponseEntity.status(HttpStatus.OK).body(signupService.signup(signupDTO));
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PostMapping("/signup/activation")
    public ResponseEntity activation(@RequestBody SignupActivationDTO signupActivationDTO) throws Exception {
        try {
            logger.info("User activated successfully!");
            return ResponseEntity.status(HttpStatus.OK).body(signupService.activate(signupActivationDTO));
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }

    @PostMapping("/signup/{role}")
    public User signup(@RequestBody SignupDTO signupDTO, @PathVariable String role) throws Exception {
        return signupService.signup(signupDTO,role);
    }

}

