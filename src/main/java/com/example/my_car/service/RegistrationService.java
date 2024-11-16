package com.example.my_car.service;

import com.example.my_car.model.AppUser;
import com.example.my_car.model.Role;
import com.example.my_car.model.RoleEnum;
import com.example.my_car.model.UserRole;
import com.example.my_car.repository.RoleRepository;
import com.example.my_car.utils.EmailValidator;
import com.example.my_car.utils.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.InstanceAlreadyExistsException;
import java.util.ArrayList;

@Service
public class RegistrationService {

    private final AppUserService appUserService;
    private final RoleRepository roleRepository;
    private final EmailValidator emailValidator;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(AppUserService appUserService, RoleRepository roleRepository,
                               EmailValidator emailValidator, PasswordEncoder passwordEncoder) {
        this.appUserService = appUserService;
        this.roleRepository = roleRepository;
        this.emailValidator = emailValidator;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public AppUser register(RegistrationRequest registrationRequest) throws InstanceAlreadyExistsException {
        boolean isValidEmail = emailValidator.test(registrationRequest.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Invalid email address");
        }
        Role role = roleRepository.findByRoleEnum(RoleEnum.USER);
        AppUser user = new AppUser(
                registrationRequest.getFirstName(),
                registrationRequest.getLastName(),
                registrationRequest.getEmail(),
                passwordEncoder.encode(registrationRequest.getPassword()),
                new ArrayList<>()
        );
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        user.addRole(userRole);
        return appUserService.signUpUser(user);


    }
}
