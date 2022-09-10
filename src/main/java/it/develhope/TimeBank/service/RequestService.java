package it.develhope.TimeBank.service;

import it.develhope.TimeBank.entities.Skill;
import it.develhope.TimeBank.entities.request.Request;
import it.develhope.TimeBank.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;
    
    public ResponseEntity<Request> createRequest (Request request){
        try {
            request.setId(null);
            requestRepository.save(request);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
    public ResponseEntity<Request> updateRequest(Long id, Request request) {
        if(requestRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        requestRepository.save(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    public ResponseEntity<Request> deleteByUsername(String username) {
        requestRepository.deleteByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    public ResponseEntity<Request> deleteRequestsById(Long id) {
        requestRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity<List<Request>> getAllRequests() {
        List<Request> allRequests = requestRepository.findAll();
        if(allRequests != null){
            return new ResponseEntity<>(allRequests, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Request> getRequestById(Long id) {
        try {
            Optional<Request> request = requestRepository.findById(id);
            return new ResponseEntity<>(request.get(), HttpStatus.OK);
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<Request> getRequestBySkill(Skill skill) {
        try{
            Optional<Request> request = requestRepository.findBySkill(skill);
            return new ResponseEntity<>(request.get(), HttpStatus.OK);
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<Request> deleteById(Long id) {
        if(id == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        requestRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity<Request> deleteAll(){
        requestRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
