package com.ghazlane.projectweb.web_project_ghazlane.api;

import com.ghazlane.projectweb.web_project_ghazlane.dao.BuildingDao;
import com.ghazlane.projectweb.web_project_ghazlane.dao.HeaterDao;
import com.ghazlane.projectweb.web_project_ghazlane.dao.RoomDao;
import com.ghazlane.projectweb.web_project_ghazlane.dao.WindowDao;
import com.ghazlane.projectweb.web_project_ghazlane.dto.RoomDto;
import com.ghazlane.projectweb.web_project_ghazlane.model.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

//Today browsers forbid a website to access to resources served by another website defined on a different domain
@CrossOrigin //@CrossOrigin(origins = { "http://localhost:3010" }, maxAge = 3600)
@RestController //  is a Spring stereotype to mark a class as a rest service
@RequestMapping("/api/rooms")
// s used to define a global URL prefix used to manage a resource (in our example all requests that start with /api/windows will be handle by this controller)
@Transactional
//  is used to delegate a transaction opening to Spring. Spring will initiate a transaction for each entry point of this controller. This is important because with Hibernate you cannot execute a query outside of a transaction.
public class RoomController {

    private final RoomDao roomDao;
    private final BuildingDao buildingDao;
    private final HeaterDao heaterDao;
    private final WindowDao windowDao;

    public RoomController(RoomDao roomDao, BuildingDao buildingDao, HeaterDao heaterDao, WindowDao windowDao) { // DAOs used by this controller are injected via constructor
        this.roomDao = roomDao;
        this.buildingDao = buildingDao;
        this.heaterDao = heaterDao;
        this.windowDao = windowDao;
    }

    @GetMapping
    // (5) @GetMapping indicates that the following method will respond to a GET request. This method will return a window list. We transform our entities Window in WindowDto
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());  // We use Java Stream API to manipulate our data
    }

    @GetMapping(path = "/{room_id}")
    public RoomDto findById(@PathVariable Long room_id) {
        return roomDao.findById(room_id).map(RoomDto::new).orElse(null); // We use Java Stream API to manipulate our data
    }

    @DeleteMapping(path = "/{room_id}")
    public void delete(@PathVariable Long room_id) {
        //delete heters;
        heaterDao.deleteAllHeaterInRoom(room_id);
        //delete windows;
        windowDao.deleteAllWindowInRoom(room_id);
        // delete room
        roomDao.deleteById(room_id);
    }

    @PutMapping(path = "/{room_id}/switchWindow")
    public RoomDto switchWindow(@PathVariable Long room_id) {
        Room room = roomDao.findById(room_id).orElseThrow(IllegalArgumentException::new);
        for (Window window : room.getWindows()) {
            window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED : WindowStatus.OPEN);
        }
        return new RoomDto(room);
    }

    @PutMapping(path = "/{room_id}/switchHeaters")
    public RoomDto switchHeater(@PathVariable Long room_id) {
        Room room = roomDao.findById(room_id).orElseThrow(IllegalArgumentException::new);
        for (Heater heater : room.getHeaters()) {
            heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.OFF ? HeaterStatus.ON : HeaterStatus.OFF);
        }
        return new RoomDto(room);
    }

    @PostMapping // (8)
    public RoomDto create(@RequestBody RoomDto dto) {
        Building building = buildingDao.getOne(dto.getBuildingId());
        Room room = null;
        if (dto.getId() == null) {
            room = roomDao.save(new Room(dto.getId(), dto.getFloor(), dto.getName(), dto.getCurrentTemperature(), dto.getTargetTemperature(), building));
        } else {
            room = roomDao.getOne(dto.getId());  // For an update you don’t need to call the DAO save method. Method getOne load the persisted data and all changes on this object (attached to a persistent context) will be updated when the transaction will be commited.
            room.setCurrentTemperature(dto.getCurrentTemperature());
            room.setFloor(dto.getFloor());
            room.setName(dto.getName());
            room.setTargetTemperature(dto.getTargetTemperature());
        }
        return new RoomDto(room);
    }
}
