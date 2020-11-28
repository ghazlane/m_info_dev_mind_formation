package com.ghazlane.projectweb.web_project_ghazlane.dao;

import com.ghazlane.projectweb.web_project_ghazlane.model.Heater;
import com.ghazlane.projectweb.web_project_ghazlane.model.Room;
import com.ghazlane.projectweb.web_project_ghazlane.model.Window;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class HeaterDaoTest {

    @Autowired
    private HeaterDao heaterDao;

    @Autowired
    private RoomDao roomDao;

    @Test
    public void shouldFindRoom() {
        Heater heater = heaterDao.getOne(-10L);
        Assertions.assertThat(heater.getName()).isEqualTo("Heater1");
        Assertions.assertThat(heater.getPower() == 2000);
    }

    @Test
    public void shouldDeleteHeatersRoom() {
        Room room = roomDao.getOne(-10L);
        List<Long> roomIds = room.getHeaters().stream().map(Heater::getId).collect(Collectors.toList());
        Assertions.assertThat(roomIds.size()).isEqualTo(2);

        heaterDao.deleteAllHeaterInRoom(-10L);
        List<Heater> result = heaterDao.findAllById(roomIds);
        Assertions.assertThat(result).isEmpty();

    }
}
