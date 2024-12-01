package com.example.my_car.service;

import com.example.my_car.model.AppUser;
import com.example.my_car.model.UserRole;
import com.example.my_car.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "User with email %s not found";
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


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AppUser> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            AppUser objUser = user.get();
            return User.builder()
                    .username(objUser.getEmail())
                    .password(objUser.getPassword())
                    .roles(getRoles(objUser))
                    .build();
        } else {
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email));
        }
    }

    private String[] getRoles(AppUser user) {
        List<UserRole> userRoles = user.getUserRoles();
        List<String> stringUserRoles = userRoles.stream()
                .map(userRole -> userRole.getRole().getRoleEnum().name())
                .toList();
        String[] arrUserRoles = new String[stringUserRoles.size()];
        for (int r = 0; r < arrUserRoles.length; r++) {
            arrUserRoles[r] = stringUserRoles.get(r);
        }
        return arrUserRoles;
    }
}
