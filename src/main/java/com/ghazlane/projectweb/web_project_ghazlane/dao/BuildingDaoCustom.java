package com.ghazlane.projectweb.web_project_ghazlane.dao;

import com.ghazlane.projectweb.web_project_ghazlane.model.Window;

import java.util.List;

public interface BuildingDaoCustom {
    List<Window> findAllWindowInBuilding(Long id);
}
