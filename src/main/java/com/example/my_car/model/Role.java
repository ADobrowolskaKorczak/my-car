package com.example.my_car.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "role")
@Getter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private RoleEnum roleEnum;

}
