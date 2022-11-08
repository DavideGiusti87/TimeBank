package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.model.Area;
import it.develhope.TimeBank.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/areas")
public class AreaController {

    private static final Logger logger = LoggerFactory.getLogger(AreaController.class);

    @Autowired
    AreaService areaService;

/*
    {
        "region":       "Campania",
        "town":         "Napoli",
        "neighborhood": "Portici"
    }

*/

    @PostMapping("/create")
    public ResponseEntity createArea(@RequestBody Area area) {
        return ResponseEntity.status(HttpStatus.OK).body(areaService.createNewArea(area));
    }
/*

    [
        {
            "region":           "Sicilia",
            "town":             "Palermo",
            "neighborhood":     "Borgo Nuovo"
        },
        {
            "region":           "Lazio",
            "town":             "Roma",
            "neighborhood":     "Collatino"
        }
    ]

 */
    @PostMapping("/createMany")
    public ResponseEntity createManyAreas(@RequestBody Area[] areas) {
        List<Area> createdAreas = new ArrayList<>();
        for (Area area : areas) {
            createdAreas.add(areaService.createNewArea(area));
        }
        return ResponseEntity.status(HttpStatus.OK).body(createdAreas);
    }

    // Main CRUD functions

    // view a single area
    @GetMapping("/findById")
    public ResponseEntity findAreaById(@RequestBody long id){
        try{
            logger.info("get area by id");
            return ResponseEntity.status(HttpStatus.OK).body(areaService.getAreaById(id));
        }catch (Exception ex){
            logger.warn(ex.getMessage());
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    // view all areas
    @GetMapping("/fetchAll")
    public ResponseEntity getAllAreas(){
        try{
            logger.info("get all areas");
            return ResponseEntity.status(HttpStatus.OK).body(areaService.getAllAreas());
        }catch (Exception ex){
            logger.warn(ex.getMessage());
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    // update an area
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody @NonNull Area area) {
        try{
            logger.info("updated area");
            return ResponseEntity.status(HttpStatus.OK).body(areaService.update(area));
        }catch (Exception ex){
            logger.warn(ex.getMessage());
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/deleteSingle")
    public void deleteSingle(@PathVariable Long id) {
            try {
                logger.info("Delete single area");
                areaService.deleteAreaById(id);
            }catch (Exception ex){
                logger.warn(ex.getMessage());
                ex.printStackTrace();
                System.out.println(ex);
            }
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        try {
            logger.info("Delete all areas");
            areaService.deleteAll();
        }catch (Exception ex){
            logger.warn(ex.getMessage());
            ex.printStackTrace();
            System.out.println(ex);

        }
    }



}
