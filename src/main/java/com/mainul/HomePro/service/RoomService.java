package com.mainul.HomePro.service;

import com.mainul.HomePro.models.Room;
import com.mainul.HomePro.springSecurity.entity.UserEntity;

import java.util.List;

public interface RoomService {
    void saveRoom(Room room, UserEntity user);

    List<Room> roomList(UserEntity user);

    Room findRoomById(Long id);

   // int countRoom()
    void deleteRoom(Long id);

}
