package com.ghazlane.projectweb.web_project_ghazlane.dao;

import com.ghazlane.projectweb.web_project_ghazlane.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingDao extends JpaRepository<Building, Long>, BuildingDaoCustom {
}
