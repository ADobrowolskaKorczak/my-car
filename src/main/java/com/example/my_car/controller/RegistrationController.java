package com.example.my_car.controller;

import com.example.my_car.dto.user.UserDTO;
import com.example.my_car.dto.user.UserMapper;
import com.example.my_car.service.RegistrationService;
import com.example.my_car.utils.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.InstanceAlreadyExistsException;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

        private final RegistrationService registrationService;

        @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody RegistrationRequest registrationRequest) throws InstanceAlreadyExistsException {
        UserDTO receivedUserDTO = UserMapper.mapToUserDTO(registrationService.register(registrationRequest));
        return ResponseEntity.ok(receivedUserDTO);

    }


}
