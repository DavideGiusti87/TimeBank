/*package it.develhope.TimeBank.controllers.old;

import io.swagger.annotations.ApiOperation;
import it.develhope.TimeBank.model.entities.Skill;
import it.develhope.TimeBank.repository.RequestRepository;
import it.develhope.TimeBank.model.request.Request;
import it.develhope.TimeBank.repository.UserRepository;
import it.develhope.TimeBank.service.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/requests")
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private RequestService requestService;
    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(RequestController.class);

   @PostMapping("/new")
   @ApiOperation(value = "new request", notes = "create a new request")
   public ResponseEntity createRequest(@RequestBody Request request) throws Exception {
       try {
           logger.info("Create a Request");
           return ResponseEntity.status(HttpStatus.OK).body(requestService.create(request));
       }catch(Exception ex){
           logger.error(ex.toString());
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
       }
   }

    @GetMapping("/fetchAll")
    @ApiOperation(value = "fetchAll", notes = "get all the request")
    public ResponseEntity getAllRequests() {
        try {
            logger.info("Get all request");
           return ResponseEntity.status(HttpStatus.OK).body(requestService.getAll());
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "id", notes = "get request by id")
    public ResponseEntity getById(@PathVariable Long id){
        try {
            logger.info("Get a request by id");
            return ResponseEntity.status(HttpStatus.OK).body(requestService.getById(id));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{skill}")
    @ApiOperation(value = "skill", notes = "get request by skill")
    public ResponseEntity getBySkill(@PathVariable Skill skill){
        try {
            logger.info("Get a request by skill");
            return ResponseEntity.status(HttpStatus.OK).body(requestService.getBySkill(skill));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "id", notes = "update request info by id")
    public ResponseEntity updateRequest(@PathVariable Long id, @RequestBody Request request){
        try {
            logger.info("Edit a request");
            return ResponseEntity.status(HttpStatus.OK).body(requestService.update(id,request));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "id", notes = "delete request by id")
    public ResponseEntity deleteById(@PathVariable Long id){

        try {
            logger.info("Delete a request by id");
            return ResponseEntity.status(HttpStatus.OK).body(requestService.deleteById(id));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{username}")
    @ApiOperation(value = "username", notes = "delete username's request")
    public ResponseEntity deleteRequestsByUsername(@PathVariable String username) {
        try {
            logger.info("Delete a request by username");
            return ResponseEntity.status(HttpStatus.OK).body(requestService.deleteByUsername(username));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    @ApiOperation(value = "deleteAll", notes = "delete all the requests")
    public ResponseEntity deleteAllRequests(){

        try {
            logger.info("Delete all requests");
            return ResponseEntity.status(HttpStatus.OK).body(requestService.deleteAll());
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

}

 */