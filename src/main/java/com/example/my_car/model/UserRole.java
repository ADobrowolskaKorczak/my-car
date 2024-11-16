package com.example.my_car.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_role")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Role role;
    @ManyToOne(fetch = FetchType.EAGER)
    private AppUser user;

}
