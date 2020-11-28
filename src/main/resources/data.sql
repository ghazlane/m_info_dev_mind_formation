INSERT INTO BUILDING(id, name) VALUES (12,'Fauriel');
INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id) VALUES(-10, 'Room1', 1, 22.3, 20.0, 12);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(-9, 'Room2', 1,12);

INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(-10, 0, 'Heater1', 2000, -10);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(-9, 0, 'Heater2', null, -10);

INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-10, 1, 'Window 1', -10);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-9, 1, 'Window 2', -10);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-8, 0, 'Window 1', -9);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-7, 1, 'Window 2', -9);
