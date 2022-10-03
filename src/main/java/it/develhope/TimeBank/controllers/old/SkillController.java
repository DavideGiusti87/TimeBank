/*package it.develhope.TimeBank.controllers.old;

import io.swagger.annotations.ApiOperation;
import it.develhope.TimeBank.model.entities.Skill;
import it.develhope.TimeBank.service.SkillsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private SkillsService skillsService;

    private static final Logger logger = LoggerFactory.getLogger(SkillController.class);

    @PostMapping("/create")
    @ApiOperation(value = "create", notes = "create a skill")
    public ResponseEntity create(@RequestBody Skill skill){
        try {
            logger.info("Create a skill");
            return ResponseEntity.status(HttpStatus.OK).body(skillsService.create(skill));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "id", notes = "update a skill")
    public ResponseEntity update(@PathVariable Long id, @RequestBody @NonNull Skill skill) throws Exception{

        try {
            logger.info("Edit a skill");
            return ResponseEntity.status(HttpStatus.OK).body(skillsService.updateSkill(id,skill));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "id", notes = "get a single skill")
    public ResponseEntity getASingleSkills(@PathVariable Long id){
        try {
            logger.info("Get a single skill");
            return ResponseEntity.status(HttpStatus.OK).body(skillsService.getASingleSkill(id));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/fetchAll")
    @ApiOperation(value = "fetchAll", notes = "get all skills")
    public ResponseEntity getAllSkills(){

        try {
            logger.info("Get all skill");
            return ResponseEntity.status(HttpStatus.OK).body(skillsService.getAllSkills());
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete", notes = "delete a single skill")
    public ResponseEntity delete(@PathVariable Long id){

        try {
            logger.info("Delete a skill by id");
            return ResponseEntity.status(HttpStatus.OK).body(skillsService.deleteById(id));
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    @ApiOperation(value = "deleteAll", notes = "delete all skills")
    public ResponseEntity deleteAll(){

        try {
            logger.info("Delete all skill");
            return ResponseEntity.status(HttpStatus.OK).body(skillsService.deleteAll());
        }catch(Exception ex){
            logger.error(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
*/