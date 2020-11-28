package com.ghazlane.projectweb.web_project_ghazlane.dao;

import com.ghazlane.projectweb.web_project_ghazlane.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomDao extends JpaRepository<Room, Long>, RoomDaoCustom {
    @Query("select c from Room c where c.currentTemperature >= c.targetTemperature")
    List<Room> findByTemperatureSuperiorOfCurrentTemperature();
}
