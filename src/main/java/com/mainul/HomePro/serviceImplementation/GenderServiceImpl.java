package com.mainul.HomePro.serviceImplementation;

import com.mainul.HomePro.models.Gender;
import com.mainul.HomePro.repository.GenderRepository;
import com.mainul.HomePro.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    private GenderRepository genderRepository;


    @Override
    public void saveGender(Gender gender) {
        genderRepository.save(gender);
    }

    @Override
    public List<Gender> getAllGenders() {
        List<Gender> genderList = genderRepository.findAll();
        return genderList;
    }

    @Override
    public Gender getGenderById(Long id) {
        Optional<Gender> optional = genderRepository.findById(id);
        Gender gender = null;
        if (optional.isPresent()) {
            gender = optional.get();
        } else {
            throw new RuntimeException("Gender is not Found" + id);
        }
        return gender;
    }


}
