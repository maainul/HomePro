package com.mainul.HomePro.serviceImplementation;

import com.mainul.HomePro.models.Room;
import com.mainul.HomePro.repository.RoomRepository;
import com.mainul.HomePro.service.RoomService;
import com.mainul.HomePro.springSecurity.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;


    @Override
    public void saveRoom(Room room, UserEntity user) {
        room.getId();
        room.getRoomName();
        room.getRoomRent();
        room.getFloorid();
        room.getExtraCharge();
        room.getGasBill();
        room.getInternetBill();
        room.setUser(user);
        this.roomRepository.save(room);
    }

    @Override
    public List<Room> roomList(UserEntity user) {
        return roomRepository.findByUser(user);
    }

    @Override
    public Room findRoomById(Long id) {
        Optional<Room> optional = roomRepository.findById(id);
        Room room = null;
        if (optional.isPresent()){
            room = optional.get();
        }else {
            throw new RuntimeException("No Room Found for id = " + id);
        }
        return room;
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }


}
