package com.ghazlane.projectweb.web_project_ghazlane.api;

import com.ghazlane.projectweb.web_project_ghazlane.dao.HeaterDao;
import com.ghazlane.projectweb.web_project_ghazlane.dao.RoomDao;
import com.ghazlane.projectweb.web_project_ghazlane.dto.HeaterDto;
import com.ghazlane.projectweb.web_project_ghazlane.model.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

//Today browsers forbid a website to access to resources served by another website defined on a different domain
@CrossOrigin //@CrossOrigin(origins = { "http://localhost:3010" }, maxAge = 3600)
@RestController //  is a Spring stereotype to mark a class as a rest service
@RequestMapping("/api/heaters")
// s used to define a global URL prefix used to manage a resource (in our example all requests that start with /api/windows will be handle by this controller)
@Transactional
//  is used to delegate a transaction opening to Spring. Spring will initiate a transaction for each entry point of this controller. This is important because with Hibernate you cannot execute a query outside of a transaction.
public class HeaterController {

    private final HeaterDao heaterDao;
    private final RoomDao roomDao;

    public HeaterController(HeaterDao heaterDao, RoomDao roomDao) { // DAOs used by this controller are injected via constructor
        this.heaterDao = heaterDao;
        this.roomDao = roomDao;
    }

    @GetMapping
    // (5) @GetMapping indicates that the following method will respond to a GET request. This method will return a window list. We transform our entities Window in WindowDto
    public List<HeaterDto> findAll() {
        return heaterDao.findAll().stream().map(HeaterDto::new).collect(Collectors.toList());  // We use Java Stream API to manipulate our data
    }

    @GetMapping(path = "/{heater_id}")
    public HeaterDto findById(@PathVariable Long heater_id) {
        return heaterDao.findById(heater_id).map(HeaterDto::new).orElse(null); // We use Java Stream API to manipulate our data
    }

    @DeleteMapping(path = "/{heater_id}")
    public void delete(@PathVariable Long heater_id) {
        heaterDao.deleteById(heater_id);
    }

    @PostMapping // (8)
    public HeaterDto create(@RequestBody HeaterDto dto) {
        Room room = roomDao.getOne(dto.getRoomId());
        Heater heater = null;
        if (dto.getId() == null) {
            heater = heaterDao.save(new Heater(dto.getName(), dto.getPower(), room, dto.getHeaterStatus()));
        } else {
            heater = heaterDao.getOne(dto.getId());  // For an update you don’t need to call the DAO save method. Method getOne load the persisted data and all changes on this object (attached to a persistent context) will be updated when the transaction will be commited.
            heater.setHeaterStatus(dto.getHeaterStatus());
        }
        return new HeaterDto(heater);
    }
}