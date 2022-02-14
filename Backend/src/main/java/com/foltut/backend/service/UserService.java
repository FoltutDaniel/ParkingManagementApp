package com.foltut.backend.service;

import com.foltut.backend.builder.userBuilder.UserRegisterBuilder;
import com.foltut.backend.dto.userDTO.UserRegisterDTO;
import com.foltut.backend.exception.UsernameAlreadyExistsException;
import com.foltut.backend.model.User;
import com.foltut.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User registerUser (UserRegisterDTO userRegisterDTO){
        User newUser = UserRegisterBuilder.generateEntityFromDto(userRegisterDTO);
        try{
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
            //Username has to be unique (exception)
            newUser.setUsername(newUser.getUsername());
            return userRepository.save(newUser);

        }catch (Exception e){
            throw new UsernameAlreadyExistsException("Username '"+newUser.getUsername()+"' already exists");
        }

    }



}