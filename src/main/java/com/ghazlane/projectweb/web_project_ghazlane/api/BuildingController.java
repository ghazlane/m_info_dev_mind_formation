package com.ghazlane.projectweb.web_project_ghazlane.api;


import com.ghazlane.projectweb.web_project_ghazlane.dao.BuildingDao;
import com.ghazlane.projectweb.web_project_ghazlane.dto.BuildingDto;
import com.ghazlane.projectweb.web_project_ghazlane.model.Building;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

//Today browsers forbid a website to access to resources served by another website defined on a different domain
@CrossOrigin //@CrossOrigin(origins = { "http://localhost:3010" }, maxAge = 3600)
@RestController //  is a Spring stereotype to mark a class as a rest service
@RequestMapping("/api/building")
// s used to define a global URL prefix used to manage a resource (in our example all requests that start with /api/windows will be handle by this controller)
@Transactional
//  is used to delegate a transaction opening to Spring. Spring will initiate a transaction for each entry point of this controller. This is important because with Hibernate you cannot execute a query outside of a transaction.
public class BuildingController {

    private final BuildingDao buildingDao;

    public BuildingController(BuildingDao buildingDao) { // DAOs used by this controller are injected via constructor
        this.buildingDao = buildingDao;
    }

    @GetMapping
    // (5) @GetMapping indicates that the following method will respond to a GET request. This method will return a window list. We transform our entities Window in WindowDto
    public List<BuildingDto> findAll() {
        return buildingDao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());  // We use Java Stream API to manipulate our data
    }

    @GetMapping(path = "/{building_id}")
    public BuildingDto findById(@PathVariable Long building_id) {
        return buildingDao.findById(building_id).map(BuildingDto::new).orElse(null); // We use Java Stream API to manipulate our data
    }

    @DeleteMapping(path = "/{building_id}")
    public void delete(@PathVariable Long building_id) {
        buildingDao.deleteById(building_id);
    }

    @PostMapping // (8)
    public BuildingDto create(@RequestBody BuildingDto dto) {
        Building building = null;
        if (dto.getId() == null) {
            building = buildingDao.save(new Building(dto.getName()));
        } else {
            building = buildingDao.getOne(dto.getId());  // For an update you don’t need to call the DAO save method. Method getOne load the persisted data and all changes on this object (attached to a persistent context) will be updated when the transaction will be commited.
            building.setName(dto.getName());
        }
        return new BuildingDto(building);
    }
}
