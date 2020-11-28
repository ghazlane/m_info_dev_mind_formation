package com.ghazlane.projectweb.web_project_ghazlane.dao;

import com.ghazlane.projectweb.web_project_ghazlane.model.Window;

import java.util.List;

public interface WindowDaoCustom {
    List<Window> findRoomOpenWindows(Long id);

    void deleteAllWindowInRoom(Long id);
}
