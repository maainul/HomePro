package com.mainul.HomePro.service;

import com.mainul.HomePro.models.Renter;

import java.util.List;

public interface RenterService {

    public Renter saveRenter(Renter renter);

    public List<Renter> renterList();

    public Renter getRenterById(Long id);

    void deleteRenterById(Long id);

    public int countMale();

    public int countFemale();

    public int totalRenter();

}
