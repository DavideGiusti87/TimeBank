package it.develhope.TimeBank.service;

import it.develhope.TimeBank.entities.request.AnonymousRequest;
import it.develhope.TimeBank.entities.request.Request;
import it.develhope.TimeBank.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;
    
    public Request saveRequest(Request request){
        request.setId(null);
        return request;
    }
    public void updateRequest(Long id, Request request) {
    }
    public void deleteRequestsByUsername(String username) {
    }
    public void deleteRequestsById(Long id) {
    }
}
