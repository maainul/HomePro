package com.mainul.HomePro.service;



import com.mainul.HomePro.models.Home;
import com.mainul.HomePro.springSecurity.entity.UserEntity;

import java.util.List;


public interface HomeService {

	void saveHome(Home home, UserEntity user);

    List<Home> getAllHome(UserEntity user);

    Home getHomeById(long id);

    void updateHome(Home home, UserEntity user);




}
