package com.example.my_car.dto.user;

import com.example.my_car.dto.userrole.UserRoleDTO;
import com.example.my_car.dto.userrole.UserRoleMapper;
import com.example.my_car.model.AppUser;
import com.example.my_car.model.UserRole;

import java.util.List;


public class UserMapper {

    public static UserDTO mapToUserDTO(AppUser appUser) {
        return UserDTO.builder()
                .id(appUser.getId())
                .firstName(appUser.getFirstName())
                .lastName(appUser.getLastName())
                .email(appUser.getEmail())
                .userRoleDTOs(mapToUserRoleDTOs(appUser.getUserRoles()))
                .build();
    }

    public static List<UserRoleDTO> mapToUserRoleDTOs(List<UserRole> userRoles) {
        return userRoles.stream()
                .map(UserRoleMapper::mapToUserRoleDTO)
                .toList();
    }

}
