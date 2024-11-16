package com.example.my_car.service;

import com.example.my_car.model.AppUser;
import com.example.my_car.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;

@Service
public class AppUserService {

    private final static String USER_NOT_FOUND_MSG = "User with email $s not found";
    private final UserRepository userRepository;

    @Autowired
    public AppUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public AppUser signUpUser(AppUser user) throws InstanceAlreadyExistsException {
        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();
        if (userExists) {
            throw new InstanceAlreadyExistsException("User exists");
        }
        return userRepository.save(user);
    }
}
