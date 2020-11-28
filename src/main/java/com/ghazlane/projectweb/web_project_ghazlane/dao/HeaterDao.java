package com.ghazlane.projectweb.web_project_ghazlane.dao;

import com.ghazlane.projectweb.web_project_ghazlane.model.Heater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeaterDao extends JpaRepository<Heater, Long>, HeaterDaoCustom {

}
