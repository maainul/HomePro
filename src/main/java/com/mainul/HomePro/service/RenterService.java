package com.mainul.HomePro.service;

import com.mainul.HomePro.models.Renter;
import com.mainul.HomePro.springSecurity.entity.UserEntity;

import java.util.List;

public interface RenterService {

    public Renter saveRenter(Renter renter, UserEntity user);

    public List<Renter> renterList(UserEntity user);

    public Renter getRenterById(Long id);

    void deleteRenterById(Long id);

    public int countMale(UserEntity user);

    public int countFemale(UserEntity user);

    public int totalRenter(UserEntity user);

}
