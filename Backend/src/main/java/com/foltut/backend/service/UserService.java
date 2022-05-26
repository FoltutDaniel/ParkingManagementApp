package com.foltut.backend.service;

import com.foltut.backend.builder.userBuilder.UserRegisterBuilder;
import com.foltut.backend.dto.requestDTO.ChangeEmailRequestDTO;
import com.foltut.backend.dto.requestDTO.ChangePasswordRequestDTO;
import com.foltut.backend.dto.userDTO.UserRegisterDTO;
import com.foltut.backend.exception.UsernameAlreadyExistsException;
import com.foltut.backend.model.User;
import com.foltut.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

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

    public Boolean changeEmail(ChangeEmailRequestDTO changeEmailRequestDTO){
        User currentUser = this.getUsernameFromSecurityContext();
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        this.getUsernameFromSecurityContext(),
                        changeEmailRequestDTO.getPassword()
                )
        );
        if(!currentUser.getEmail().equals(changeEmailRequestDTO.getOldEmail())){
            return false;
        }
        currentUser.setEmail(changeEmailRequestDTO.getNewEmail());
        userRepository.save(currentUser);
        return true;
    }

    public Boolean changePassword(ChangePasswordRequestDTO changePasswordRequestDTO){
        User currentUser = this.getUsernameFromSecurityContext();
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        this.getUsernameFromSecurityContext(),
                        changePasswordRequestDTO.getOldPassword()
                )
        );
        currentUser.setPassword(bCryptPasswordEncoder.encode(changePasswordRequestDTO.getNewPassword()));
        userRepository.save(currentUser);
        return true;
    }

    public User getUsernameFromSecurityContext(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            return userRepository.findByUsername(username).get();
        } else {
            String username = principal.toString();
            return userRepository.findByUsername(username).get();
        }

    }



}