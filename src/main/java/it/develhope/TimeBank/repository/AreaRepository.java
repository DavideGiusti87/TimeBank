package it.develhope.TimeBank.repository;

import it.develhope.TimeBank.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
    public List<Area> findByRegionAndTownAndNeighborhood(String region, String town, String neighborhood);
}
