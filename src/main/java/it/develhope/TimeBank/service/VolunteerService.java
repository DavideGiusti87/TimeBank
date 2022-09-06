package it.develhope.TimeBank.service;

import it.develhope.TimeBank.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerRepository repository;


}
