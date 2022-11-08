package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.model.*;
import it.develhope.TimeBank.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    private static Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/generateRoles")
    public ResponseEntity generateRoles() {
        return ResponseEntity.status(HttpStatus.OK).body(authService.generateRoles());
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody SignupDTO signupDTO) /*throws Exception */{
        try {
            logger.info("Registration successful!");
            return ResponseEntity.status(HttpStatus.OK).body(authService.signup(signupDTO));
        }catch (Exception ex){
            logger.error(ex.getMessage());
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PostMapping("/signup/activation")
    public ResponseEntity activation(@RequestParam String activationCode) throws Exception {
        try {
            logger.info("User activated successfully!");
            return ResponseEntity.status(HttpStatus.OK).body(authService.activate(activationCode));
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }

    @PostMapping("/signup/{role}")
    public User signup(@RequestBody SignupDTO signupDTO, @PathVariable String role) throws Exception {
        logger.info("Registration successful!");
        return authService.signup(signupDTO,role);
    }

    @PostMapping("/login")
    public LoginRTO login(@RequestBody LoginDTO loginDTO) throws Exception{
        LoginRTO loginRTO = authService.login(loginDTO);
        if (loginRTO == null) throw new Exception("Cannot login");
        return loginRTO;
    }

}

