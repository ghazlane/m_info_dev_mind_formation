package com.ghazlane.projectweb.web_project_ghazlane.dao;

import com.ghazlane.projectweb.web_project_ghazlane.model.Window;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BuildingDaoTest {
    @Autowired
    private BuildingDao buildingDAO;

    @Test
    public void shouldNotFindRoomOpenWindows() {
        List<Window> result = buildingDAO.findAllWindowInBuilding(-10L);
        Assertions.assertThat(result).isEmpty();

        List<Window> result2 = buildingDAO.findAllWindowInBuilding(12L);
        Assertions.assertThat(result2)
                .hasSize(4);

    }
}
