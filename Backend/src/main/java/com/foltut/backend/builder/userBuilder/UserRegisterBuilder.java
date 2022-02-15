package com.foltut.backend.builder.userBuilder;

import com.foltut.backend.dto.userDTO.UserRegisterDTO;
import com.foltut.backend.model.User;

public class UserRegisterBuilder {

    public static User generateEntityFromDto(UserRegisterDTO userRegisterDTO){
        return new User(
                userRegisterDTO.getUsername(),
                userRegisterDTO.getFirstName(),
                userRegisterDTO.getLastName(),
                userRegisterDTO.getEmail(),
                userRegisterDTO.getPassword()
        );
    }
}
