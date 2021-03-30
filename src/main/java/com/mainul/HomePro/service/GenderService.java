package com.mainul.HomePro.service;

import com.mainul.HomePro.models.Gender;

import java.util.List;

public interface GenderService {

    void saveGender(Gender gender);

    List<Gender> getAllGenders();

    Gender getGenderById(Long id);

}
