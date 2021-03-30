package com.mainul.HomePro.service;

import com.mainul.HomePro.models.Renter;

import java.util.List;

public interface RenterService {

    public void saveRenter(Renter renter);

    public List<Renter> renterList();

    public Renter getRenterById(Long id);
}
