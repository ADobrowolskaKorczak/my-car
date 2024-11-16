package com.example.my_car.repository;

import com.example.my_car.model.Role;
import com.example.my_car.model.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRoleEnum(RoleEnum roleEnum);

}
