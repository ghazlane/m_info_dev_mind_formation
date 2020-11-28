package com.ghazlane.projectweb.web_project_ghazlane.dao;

import com.ghazlane.projectweb.web_project_ghazlane.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WindowDao extends JpaRepository<Window, Long>, WindowDaoCustom {

}
