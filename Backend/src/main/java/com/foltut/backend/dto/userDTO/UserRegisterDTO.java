package com.foltut.backend.dto.userDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegisterDTO {

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

}
