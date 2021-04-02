package com.mainul.HomePro.service;

import com.mainul.HomePro.models.Room;

import java.util.List;

public interface RoomService {
    void saveRoom(Room room);

    List<Room> roomList();

    Room findRoomById(Long id);

   // int countRoom()

}
