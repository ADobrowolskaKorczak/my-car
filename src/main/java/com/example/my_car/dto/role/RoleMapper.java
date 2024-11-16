package com.example.my_car.dto.role;

import com.example.my_car.model.Role;

public class RoleMapper {

    public static RoleDTO mapToRoleDTO(Role role) {
        return RoleDTO.builder()
                .roleEnum(role.getRoleEnum())
                .build();
    }

}
