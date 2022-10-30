package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.model.Area;
import it.develhope.TimeBank.service.AreaService;
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
            return ResponseEntity.status(HttpStatus.OK).body(areaService.getAreaById(id));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    // view all areas
    @GetMapping("/fetchAll")
    public ResponseEntity getAllAreas(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(areaService.getAllAreas());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    // update an area
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody @NonNull Area area) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(areaService.update(area));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    // TODO delete a single area
    // TODO delete all areas


}
