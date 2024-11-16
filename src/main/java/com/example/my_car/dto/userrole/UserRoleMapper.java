package com.example.my_car.dto.userrole;

import com.example.my_car.dto.role.RoleMapper;
import com.example.my_car.model.UserRole;

public class UserRoleMapper {

    public static UserRoleDTO mapToUserRoleDTO(UserRole userRole) {
        return UserRoleDTO.builder()
                .roleDTO(RoleMapper.mapToRoleDTO(userRole.getRole()))
                .build();
    }

}
