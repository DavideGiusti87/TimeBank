package it.develhope.TimeBank.service;

import it.develhope.TimeBank.entities.request.AnonymousRequest;
import it.develhope.TimeBank.entities.request.Request;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {
    
    public Request saveRequest(Request request){
        return request;
    }
    public void updateRequest(Long id, Request request) {
    }
    public void deleteRequestsByUsername(String username) {
    }
    public void deleteRequestsById(Long id) {
    }
}
