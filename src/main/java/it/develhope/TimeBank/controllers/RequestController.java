package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.exceptions.RequestNotFoundException;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

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


    // TODO in createNew l'utente deve essere loggato e le sue informazioni di contatto devono essere prese dalla sua utenza
    @PreAuthorize("hasRole('ROLE_REGISTERED') or hasRole('ROLE_ADMIN')")
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

// TODO vedere tutte le richieste, vedere solo quelle non ancora accettate, vedere quelle accettate da un preciso volontario
//il file JSON non mostra l'id della richiesta
    @PreAuthorize("hasRole('ROLE_REGISTERED') or hasRole('ROLE_ADMIN')")
    @GetMapping("/view")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(requestService.getAll());
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
//se l'id del volontario è nullo fa vedere solo le richieste del volontario loggato altrimenti del volonotario a cui corrisponde l'id passato
    @PreAuthorize("hasRole('ROLE_REGISTERED') or hasRole('ROLE_ADMIN')")
    @GetMapping("/getAllByVolunteer")
    public ResponseEntity getAllByVolunteer(@RequestParam(required = false) Long volunteerId, Principal principal) {
        try {
            if (volunteerId == null) {
                User user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
                return ResponseEntity.status(HttpStatus.OK).body(requestService.getAllByVolunteer(user.getId()));
            }
            return ResponseEntity.status(HttpStatus.OK).body(requestService.getAllByVolunteer(volunteerId));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    //prende in consegna la richiesta dal volontario
    @PreAuthorize("hasRole('ROLE_REGISTERED') or hasRole('ROLE_ADMIN')")
    @PostMapping("/takeOverRequest")
    public ResponseEntity takeOverRequest(@RequestParam Long requestId, Principal principal) {
        User user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        try {
            return ResponseEntity.status(HttpStatus.OK).body(requestService.takeOverRequest(requestId, user));
        } catch (RequestNotFoundException e) {
            logger.warn(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    //per vedere solo le richieste non ancora prese in carico
    @PreAuthorize("hasRole('ROLE_REGISTERED') or hasRole('ROLE_ADMIN')")
    @GetMapping("/viewAllNotTakeOver")
    public ResponseEntity viewAllNotTakeOver() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(requestService.getWithVolunteerNull());
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }


}