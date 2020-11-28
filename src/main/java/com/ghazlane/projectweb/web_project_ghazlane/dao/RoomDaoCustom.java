package com.ghazlane.projectweb.web_project_ghazlane.dao;

import com.ghazlane.projectweb.web_project_ghazlane.model.Room;
import com.ghazlane.projectweb.web_project_ghazlane.model.Window;

import java.util.List;

public interface RoomDaoCustom {
    List<Room> findRoomsByName(String name);
}
