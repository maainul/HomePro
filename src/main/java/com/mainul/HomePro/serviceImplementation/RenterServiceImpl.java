package com.mainul.HomePro.serviceImplementation;

import com.mainul.HomePro.models.Rent;
import com.mainul.HomePro.models.Renter;
import com.mainul.HomePro.repository.RenterRepository;
import com.mainul.HomePro.service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RenterServiceImpl implements RenterService {

    @Autowired
    private RenterRepository renterRepository;

    @Override
    public Renter saveRenter(Renter renter) {
        renterRepository.save(renter);
        return renter;
    }

    @Override
    public List<Renter> renterList() {
        List<Renter> renters = renterRepository.findAll();
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
    public int countMale() {
        List<Renter> renters = renterRepository.findAll();
        int count = 0;
        for (Renter renter : renters) {
            if (renter.getGender().equalsIgnoreCase("MALE")) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int countFemale() {
        List<Renter> renters = renterRepository.findAll();
        int count = 0;
        for (Renter renter : renters) {
            if (renter.getGender().equalsIgnoreCase("FEMALE")) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int totalRenter() {
        List<Renter> renters = renterRepository.findAll();
        int totalRenters = (int) renters.stream().count();
        return totalRenters;
    }


}

