package it.develhope.TimeBank.service;

import it.develhope.TimeBank.model.*;
import it.develhope.TimeBank.repository.RequestRepository;
import it.develhope.TimeBank.repository.SkillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    private static Logger logger = LoggerFactory.getLogger(RequestService.class);

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    AreaService areaService;

    @Autowired
    UserService userService;

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    SkillService skillService;

    /*
    Ricevo in ingresso una AnonymousRequestDTO.
    La uso per costruire una entity Request, la inserisco nel DB e la restituisco all'utente
    */
    public Request createAnonymousRequest(AnonymousRequestDTO request) throws Exception {
        Request newRequest = new Request();
        newRequest.setAnonymous(true);
        newRequest.setTitle(request.getTitle());
        newRequest.setDescription((request.getDescription()));
        newRequest.setUsername(request.getContactName());
        newRequest.setPhoneNumber(request.getTelephoneNumber());
        newRequest.setEmail(request.getEmail());
        // non c'è un recipientUser perché la richiesta è anonima
        newRequest.setArea(areaService.getAreaById(request.getAreaId()));
        List<Skill> skillsList = new ArrayList<>();
        for (Long skillId : request.getSkillIds()) {
            skillsList.add(skillService.getASingleSkill(skillId));
        }
        newRequest.setRequiredSkills(skillsList);
        return requestRepository.save(newRequest);
    }

    public Request createNewRequest(RequestDTO request, User user) throws Exception {
        Request newRequest = new Request();

        newRequest.setAnonymous(false);
        newRequest.setTitle(request.getTitle());
        newRequest.setDescription((request.getDescription()));
        newRequest.setUsername(user.getUsername());
        newRequest.setPhoneNumber(user.getTelephoneNumber());
        newRequest.setEmail(user.getEmail());
        newRequest.setRecipientUser(user);
        newRequest.setArea(areaService.getAreaById(request.getAreaId()));
        List<Skill> skillsList = new ArrayList<>();
        for (Long skillId : request.getSkillIds()) {
            skillsList.add(skillService.getASingleSkill(skillId));
        }
        newRequest.setRequiredSkills(skillsList);
        return requestRepository.save(newRequest);
    }


    public List<Request> getAll() {
        return requestRepository.findAll();
    }

    public Optional<Request> getExecution(String volunteer) {
        if(volunteer.isEmpty()||volunteer.isBlank()){
            return requestRepository.findByVolunteer(null);
        }
        return requestRepository.findByVolunteer(volunteer);
    }
}
