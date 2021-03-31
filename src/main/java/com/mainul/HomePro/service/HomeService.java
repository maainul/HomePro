package com.mainul.HomePro.service;



import com.mainul.HomePro.models.Home;

import java.util.List;


public interface HomeService {

	void saveHome(Home home);

    List<Home> getAllHome();

    Home getHomeById(long id);




}
