package com.example.my_car.dto.user;

import com.example.my_car.dto.userrole.UserRoleDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private List<UserRoleDTO> userRoleDTOs;


}
