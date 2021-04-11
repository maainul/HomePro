package com.mainul.HomePro.repository;

import com.mainul.HomePro.models.Room;
import com.mainul.HomePro.springSecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByUser(UserEntity user);
}
