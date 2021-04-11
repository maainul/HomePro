package com.mainul.HomePro.serviceImplementation;

import com.mainul.HomePro.models.Rent;
import com.mainul.HomePro.models.Renter;
import com.mainul.HomePro.repository.RenterRepository;
import com.mainul.HomePro.service.RenterService;
import com.mainul.HomePro.springSecurity.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RenterServiceImpl implements RenterService {

    @Autowired
    private RenterRepository renterRepository;

    @Override
    public Renter saveRenter(Renter renter, UserEntity user) {
        renter.getId();
        renter.getFirstName();
        renter.getLastName();
        renter.getMiddleName();
        renter.getPhoneNumber1();
        renter.getPermanentAddress();
        renter.getEmail();
        renter.getAdvanceMonth();
        renter.getDateOfBirth();
        renter.getDiscount();
        renter.getFacebook();
        renter.getGender();
        renter.getNID();
        renter.getMaritalStatus();
        renter.getOccupation();
        renter.getOfficeJoinDate();
        renter.getPhoneNumber2();
        renter.getOfficeName();
        renter.getOfficePost();
        renter.getRentalDate();
        renter.getRenterImage();
        renter.getRentersImagePath();
        renter.setUser(user);
        return renterRepository.save(renter);
    }

    @Override
    public List<Renter> renterList(UserEntity user) {
        List<Renter> renters = renterRepository.findByUser(user);
        return renters;
    }

    @Override
    public Renter getRenterById(Long id) {
        Optional<Renter> optional = renterRepository.findById(id);
        Renter renter = null;
        if (optional.isPresent()) {
            renter = optional.get();
        } else {
            throw new RuntimeException("Renter not found");
        }
        return renter;
    }

    @Override
    public void deleteRenterById(Long id) {
        renterRepository.deleteById(id);
    }

    @Override
    public int countMale(UserEntity user) {
        List<Renter> renters = renterRepository.findByUser(user);
        int count = 0;
        for (Renter renter : renters) {
            if (renter.getGender().equalsIgnoreCase("MALE")) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int countFemale(UserEntity user) {
        List<Renter> renters = renterRepository.findByUser(user);
        int count = 0;
        for (Renter renter : renters) {
            if (renter.getGender().equalsIgnoreCase("FEMALE")) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int totalRenter(UserEntity user) {
        List<Renter> renters = renterRepository.findByUser(user);
        int totalRenters = (int) renters.stream().count();
        return totalRenters;
    }


}

