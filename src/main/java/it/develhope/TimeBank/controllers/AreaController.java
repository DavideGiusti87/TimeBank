package it.develhope.TimeBank.controllers;

import it.develhope.TimeBank.model.Area;
import it.develhope.TimeBank.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/areas")
public class AreaController {

    @Autowired
    AreaService areaService;

    @PostMapping("/create")
    public ResponseEntity createArea(@RequestBody Area area) {
        return ResponseEntity.status(HttpStatus.OK).body(areaService.createNewArea(area));
    }

    @PostMapping("/createMany")
    public ResponseEntity createManyAreas(@RequestBody Area[] areas) {
        List<Area> createdAreas = new ArrayList<>();
        for (Area area : areas) {
            createdAreas.add(areaService.createNewArea(area));
        }
        return ResponseEntity.status(HttpStatus.OK).body(createdAreas);
    }

    // Main CRUD functions
    // TODO delete a single area
    // TODO delete all areas
    // TODO update an area
    // TODO view a single area
    // TODO view all areas

}
