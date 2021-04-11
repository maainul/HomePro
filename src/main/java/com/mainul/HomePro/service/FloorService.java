package com.mainul.HomePro.service;

import com.mainul.HomePro.models.Floor;
import com.mainul.HomePro.springSecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FloorService {

    void saveFloor(Floor floor, UserEntity user);

    List<Floor> getAllFloors(UserEntity user);

    Floor getFloorById(long id);

    void deleteFloorById(Long id);



}
