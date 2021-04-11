package com.mainul.HomePro.serviceImplementation;

import com.mainul.HomePro.models.Floor;
import com.mainul.HomePro.repository.FloorRepository;
import com.mainul.HomePro.service.FloorService;
import com.mainul.HomePro.springSecurity.entity.UserEntity;
import com.mainul.HomePro.springSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FloorServiceImpl implements FloorService {

    @Autowired
    private FloorRepository floorRepository;

    @Autowired private UserService userService;

    @Override
    public void saveFloor(Floor floor, UserEntity user) {
        floor.getId();
        floor.getFloorName();
        floor.setUser(user);
        this.floorRepository.save(floor);
    }

    @Override
    public List<Floor> getAllFloors(UserEntity user) {
        return floorRepository.findByUser(user);
    }

    @Override
    public Floor getFloorById(long id) {
        Optional<Floor> optionalFloor = floorRepository.findById(id);
        Floor floor = null;
        if (optionalFloor.isPresent()){
            floor = optionalFloor.get();
        }else {
            throw new RuntimeException("Floor not found for id ::"+ id);
        }
        return floor;
    }

    @Override
    public void deleteFloorById(Long id) {
        floorRepository.deleteById(id);
    }


}
