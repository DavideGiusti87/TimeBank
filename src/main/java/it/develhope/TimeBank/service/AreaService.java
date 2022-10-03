package it.develhope.TimeBank.service;

import it.develhope.TimeBank.exceptions.DirtyDataFoundException;
import it.develhope.TimeBank.model.entities.Area;
import it.develhope.TimeBank.repository.AreaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService {

    private static final Logger logger = LoggerFactory.getLogger(AreaService.class);


    @Autowired
    AreaRepository areaRepository;

    public Optional<Area> getAreaByPerfectMatch(Area area) {
        List<Area> matchingAreas = areaRepository.findByRegionAndTownAndNeighborhood(
                area.getRegion(), area.getTown(), area.getNeighborhood());
        if (matchingAreas.size() > 1) {
            try {
                throw new DirtyDataFoundException(String.format(
                        "Duplicate areas have been found: %s, %s, %s",
                        area.getRegion(),
                        area.getTown(),
                        area.getNeighborhood()));
            } catch (DirtyDataFoundException e) {
                logger.warn(e.getMessage());
                return Optional.empty();
            }
        }
        else if(matchingAreas.size() == 1) {
            return Optional.of(matchingAreas.get(0));
        }
        return Optional.empty();
    }

    public Area createNewArea(Area area) {
        return areaRepository.save(area);
    }

}
