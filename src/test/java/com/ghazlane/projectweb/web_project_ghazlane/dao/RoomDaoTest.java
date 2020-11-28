package com.ghazlane.projectweb.web_project_ghazlane.dao;

import com.ghazlane.projectweb.web_project_ghazlane.model.Room;
import com.ghazlane.projectweb.web_project_ghazlane.model.Window;
import com.ghazlane.projectweb.web_project_ghazlane.model.WindowStatus;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RoomDaoTest {

    @Autowired
    private RoomDao roomDao;

    @Test
    public void shouldFindRoom() {
        Room room = roomDao.getOne(-10L);
        Assertions.assertThat(room.getName()).isEqualTo("Room1");
        Assertions.assertThat(room.getTargetTemperature() == 20.0);
    }

    @Test
    public void shouldCurrentSuperiorTarget() {
        List<Room> rooms = roomDao.findByTemperatureSuperiorOfCurrentTemperature();
        for (Room room : rooms) {
            Assertions.assertThat(room.getCurrentTemperature() >= room.getTargetTemperature());
        }
    }

    @Test
    public void findRoomsByName() {
        List<Room> result = roomDao.findRoomsByName("Room1");
        Assertions.assertThat(result)
                .hasSize(1)
                .extracting("name", "id")
                .containsExactly(Tuple.tuple("Room1", -10L));
    }
}
