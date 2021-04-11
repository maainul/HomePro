package com.mainul.HomePro.springSecurity.service.impl;


import com.mainul.HomePro.springSecurity.data.user.UserData;
import com.mainul.HomePro.springSecurity.entity.UserEntity;
import com.mainul.HomePro.springSecurity.exception.UserAlreadyExistException;
import com.mainul.HomePro.springSecurity.repository.UserRepository;
import com.mainul.HomePro.springSecurity.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service("userService")

public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Value("${site.base.url.https}")
    private String baseURL;

    @Override
    public void register(UserData user) throws UserAlreadyExistException {
        if (checkIfUserExist(user.getEmail())) {
            throw new UserAlreadyExistException("User already exists for this email");
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        encodePassword(user, userEntity);
        userRepository.save(userEntity);

    }

    private void encodePassword(UserData source, UserEntity target) {
        target.setPassword(passwordEncoder.encode(source.getPassword()));
    }

    @Override
    public boolean checkIfUserExist(String email) {
        return userRepository.findByEmail(email) != null ? true : false;
    }

    @Override
    public UserEntity findByUsername(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public String firstAndLastName(String email) {
        String firstName = userRepository.findByEmail(email).getFirstName();
        String lastName = userRepository.findByEmail(email).getLastName();
        return firstName + " " + lastName;
    }


}