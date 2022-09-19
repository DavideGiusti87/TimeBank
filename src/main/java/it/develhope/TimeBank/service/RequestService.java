package it.develhope.TimeBank.service;

import it.develhope.TimeBank.entities.Skill;
import it.develhope.TimeBank.entities.request.Request;
import it.develhope.TimeBank.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public Request create(Request request) throws Exception {
        try {
            request.setId(null);
            return requestRepository.save(request);
        } catch (Exception ex) {
            throw new Exception("Bad input");
        }

    }

    public Request update(Long id, Request request) throws Exception {

        if (!requestRepository.existsById(id)) {
            throw new Exception("Insert an existing Id");
        }
        return requestRepository.save(request);
    }


    public List<Request> getAll() throws Exception {

        List<Request> allRequests = requestRepository.findAll();
        if (allRequests.isEmpty()) {
            throw new Exception("The request list is empty");
        }
        return allRequests;
    }

    public Optional<Request> getById(Long id) throws Exception {
        try {
            Optional<Request> request = requestRepository.findById(id);
            return request;
        } catch (Exception ex) {
            throw new Exception("Id not found ");
        }
    }

    public Optional<Request> getBySkill(Skill skill) throws Exception {
        try {
            Optional<Request> request = requestRepository.findBySkill(skill);
            return request;
        } catch (Exception ex) {
            throw new Exception("Skill not found");
        }
    }

    public Request deleteByUsername(String username) throws Exception {
        try {
            return requestRepository.deleteByUsername(username);
        } catch (Exception ex) {
            throw new Exception("Username not found");
        }
    }

    public String deleteById(Long id) throws Exception {

        try {
            if (requestRepository.existsById(id)) {
                requestRepository.deleteById(id);
                return "The request with id " + id + " has been deleted.";
            }
        } catch (Exception ex) {
            throw new Exception("Id not found");
        }
        return null;
    }

    public String deleteAll() throws Exception {
        try {
            requestRepository.deleteAll();
            return "All requests have been deleted.";
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
