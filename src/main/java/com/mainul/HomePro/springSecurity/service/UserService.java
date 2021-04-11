package com.mainul.HomePro.springSecurity.service;


import com.mainul.HomePro.springSecurity.data.user.UserData;
import com.mainul.HomePro.springSecurity.entity.UserEntity;
import com.mainul.HomePro.springSecurity.exception.UserAlreadyExistException;

public interface UserService {

    void register(final UserData user) throws UserAlreadyExistException;

    boolean checkIfUserExist(final String email);

    UserEntity findByUsername(String name);
}