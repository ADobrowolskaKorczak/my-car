package com.example.my_car.utils;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Builder
public class RegistrationRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
