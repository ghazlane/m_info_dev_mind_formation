package com.ghazlane.projectweb.web_project_ghazlane.api;

import com.ghazlane.projectweb.web_project_ghazlane.dao.RoomDao;
import com.ghazlane.projectweb.web_project_ghazlane.dao.WindowDao;
import com.ghazlane.projectweb.web_project_ghazlane.dto.WindowDto;
import com.ghazlane.projectweb.web_project_ghazlane.model.Room;
import com.ghazlane.projectweb.web_project_ghazlane.model.Window;
import com.ghazlane.projectweb.web_project_ghazlane.model.WindowStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

//Today browsers forbid a website to access to resources served by another website defined on a different domain
@CrossOrigin //@CrossOrigin(origins = { "http://localhost:3010" }, maxAge = 3600)
@RestController //  is a Spring stereotype to mark a class as a rest service
@RequestMapping("/api/windows")
// s used to define a global URL prefix used to manage a resource (in our example all requests that start with /api/windows will be handle by this controller)
@Transactional
//  is used to delegate a transaction opening to Spring. Spring will initiate a transaction for each entry point of this controller. This is important because with Hibernate you cannot execute a query outside of a transaction.
public class WindowController {

    private final WindowDao windowDao;
    private final RoomDao roomDao;

    public WindowController(WindowDao windowDao, RoomDao roomDao) { // DAOs used by this controller are injected via constructor
        this.windowDao = windowDao;
        this.roomDao = roomDao;
    }

    @GetMapping
    // (5) @GetMapping indicates that the following method will respond to a GET request. This method will return a window list. We transform our entities Window in WindowDto
    public List<WindowDto> findAll() {
        return windowDao.findAll().stream().map(WindowDto::new).collect(Collectors.toList());  // We use Java Stream API to manipulate our data
    }

    @GetMapping(path = "/{id}")
    public WindowDto findById(@PathVariable Long id) {
        return windowDao.findById(id).map(WindowDto::new).orElse(null); // We use Java Stream API to manipulate our data
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        windowDao.deleteById(id);
    }

    @PutMapping(path = "/{id}/switch")
    public WindowDto switchStatus(@PathVariable Long id) {
        Window window = windowDao.findById(id).orElseThrow(IllegalArgumentException::new);
        window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED : WindowStatus.OPEN);
        return new WindowDto(window);
    }

    @PostMapping // (8)
    public WindowDto create(@RequestBody WindowDto dto) {
        // WindowDto must always contain the window room
        Room room = roomDao.getOne(dto.getRoomId());
        Window window = null;
        // On creation id is not defined
        if (dto.getId() == null) {
            window = windowDao.save(new Window(room, dto.getName(), dto.getWindowStatus()));
        } else {
            window = windowDao.getOne(dto.getId());  // For an update you don’t need to call the DAO save method. Method getOne load the persisted data and all changes on this object (attached to a persistent context) will be updated when the transaction will be commited.
            window.setWindowStatus(dto.getWindowStatus());
        }
        return new WindowDto(window);
    }
}
