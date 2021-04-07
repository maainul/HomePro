package com.mainul.HomePro.service;

import com.mainul.HomePro.models.Floor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FloorService {

    void saveFloor(Floor floor);

    List<Floor> getAllFloors();

    Floor getFloorById(long id);

    void deleteFloorById(Long id);
}
