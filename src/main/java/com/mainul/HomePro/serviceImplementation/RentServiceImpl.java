package com.mainul.HomePro.serviceImplementation;

import com.mainul.HomePro.models.Rent;
import com.mainul.HomePro.repository.RentRepository;
import com.mainul.HomePro.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepository rentRepository;

    @Override
    public void saveRent(Rent rent) {
        rentRepository.save(rent);
    }

    @Override
    public List<Rent> getAllRent() {
        return rentRepository.findAll();
    }

    @Override
    public Rent getRentById(Long id) {
        Optional<Rent> optional = rentRepository.findById(id);
        Rent rent = null;
        if (optional.isPresent()){
            rent = optional.get();
        }else {
            throw new RuntimeException("no rent found");
        }
        return rent;
    }

    @Override
    public int totalRent() {
        List<Rent> rents = rentRepository.findAll();
        int rentTotal = 0;
        for (Rent rent : rents){
           // System.out.println(rent.getRoomRent());
            rentTotal += rent.getRoomRent();
        }
        return rentTotal;
    }

    @Override
    public int totalElectricityBill() {
        List<Rent> rents = rentRepository.findAll();
        int totalElectricityBill = 0;
        for (Rent rent : rents){
            totalElectricityBill += rent.getElectricityBill();
        }
        return totalElectricityBill;
    }


}
