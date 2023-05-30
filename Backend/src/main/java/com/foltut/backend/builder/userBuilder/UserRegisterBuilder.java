package com.foltut.backend.builder.userBuilder;

import com.foltut.backend.dto.userDTO.UserRegisterDTO;
import com.foltut.backend.model.User;

public class UserRegisterBuilder {

    public static User generateEntityFromDto(UserRegisterDTO userRegisterDTO) {
        return User.builder().username(userRegisterDTO.getUsername())
                .firstName(userRegisterDTO.getFirstName())
                .lastName(userRegisterDTO.getLastName())
                .email(userRegisterDTO.getEmail())
                .password(userRegisterDTO.getPassword())
                .build();
    }
}
