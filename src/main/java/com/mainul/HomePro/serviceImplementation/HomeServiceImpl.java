package com.mainul.HomePro.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainul.HomePro.models.Home;

import com.mainul.HomePro.repository.HomeRepository;
import com.mainul.HomePro.service.HomeService;

import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements HomeService{
	
	@Autowired
	private HomeRepository homeRepository;

	@Override
	public void saveHome(Home home) {
		this.homeRepository.save(home);
		
	}

	@Override
	public List<Home> getAllHome() {
		return homeRepository.findAll();
	}



	@Override
	public Home getHomeById(long id) {
		Optional<Home> optionalHome = homeRepository.findById(id);
		Home home = null;
		if (optionalHome.isPresent()){
			home = optionalHome.get();
		}else {
			throw  new RuntimeException("Home Not Found");
		}

		return home;
	}


}
