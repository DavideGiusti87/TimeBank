package it.develhope.TimeBank.service;

import it.develhope.TimeBank.exceptions.MissingAreaException;
import it.develhope.TimeBank.model.DTO.RequestDTO;
import it.develhope.TimeBank.model.entities.Area;
import it.develhope.TimeBank.model.entities.Request;
import it.develhope.TimeBank.model.entities.Skill;
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

    public Request createNewRequest(RequestDTO newRequestDTO) throws MissingAreaException {
        Request newRequest = new Request();

        // get the area from the database if already exists, create a new one otherwise
        if (newRequestDTO.getArea() == null) {
            throw new MissingAreaException();
        }
        else {
            Optional<Area> matchingArea = areaService
                    .getAreaByPerfectMatch(newRequestDTO.getArea());
            if (matchingArea.isPresent()) {
                newRequest.setArea(matchingArea.get());
            }
            else {
                newRequest.setArea(areaService.createNewArea(newRequestDTO.getArea()));
            }
        }

        // set user: from db if requested, anonymous otherwise
        if (newRequestDTO.isUseDefaultUserContactInformation()) {
            newRequest.setAnonynous(false);
            // TODO when login is implemented, get user info from JWT
            logger.warn("Users are not implemented yet!");
        }
        else {
            newRequest.setUsername(newRequestDTO.getUsername());
            newRequest.setEmail(newRequestDTO.getEmail());
            newRequest.setPhoneNumber(newRequest.getPhoneNumber());
            // there is a singleton anonymous user -> check UserService class, it's nice
            newRequest.setRecipientUser(userService.getAnonymousUser());
        }

        newRequest.setDescription(newRequestDTO.getDescription());

        List<Skill> requiredSkills = new ArrayList<>();
        for (String skillString : newRequestDTO.getRequiredSkills()) {
            // TODO do this with a service
            Optional<Skill> skill = skillRepository.findByName(skillString);
                if (skill.isPresent()) {
                    requiredSkills.add(skill.get());
                }
                else {
                    // TODO decide what to do
                    logger.warn("TODO Decide what to do with new skills");
                }
        }
        newRequest.setRequiredSkills(requiredSkills);

        return requestRepository.save(newRequest);
    }

}
