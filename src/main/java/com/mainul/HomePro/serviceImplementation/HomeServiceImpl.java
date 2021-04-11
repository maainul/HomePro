package com.mainul.HomePro.serviceImplementation;

import com.mainul.HomePro.springSecurity.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainul.HomePro.models.Home;

import com.mainul.HomePro.repository.HomeRepository;
import com.mainul.HomePro.service.HomeService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeRepository homeRepository;



/*
	@Override
	public List<Home> getAllHome() {
		return homeRepository.findAll();
	}
*/


    @Override
    public void saveHome(Home home1, UserEntity user) {

        home1.getId();
        home1.getHomeName();
        home1.getBuyerName();
        home1.getFinalPaymentDate();
        home1.getFirstPaymentAmount();
        home1.getPropertyLocation();
        home1.getPropertyPrice();
        home1.getPropertySize();
        home1.getFirstPaymentDate();
        home1.getSellerName();
        home1.setUser(user);

        homeRepository.save(home1);

    }

    @Override
    public List<Home> getAllHome(UserEntity user) {
        List<Home> homeList = homeRepository.findAllByUser(user);
        return homeList;
        //return homeList.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    @Override
    public Home getHomeById(long id) {
        Optional<Home> optionalHome = homeRepository.findById(id);
        Home home = null;
        if (optionalHome.isPresent()) {
            home = optionalHome.get();
        } else {
            throw new RuntimeException("Home Not Found");
        }

        return home;
    }

    @Override
    public void updateHome(Home home, UserEntity user) {

    }


}
