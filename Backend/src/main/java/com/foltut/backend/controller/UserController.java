package com.foltut.backend.controller;

import com.foltut.backend.dto.requestDTO.ChangeEmailRequestDTO;
import com.foltut.backend.dto.requestDTO.ChangePasswordRequestDTO;
import com.foltut.backend.dto.userDTO.UserLoginDTO;
import com.foltut.backend.dto.userDTO.UserRegisterDTO;
import com.foltut.backend.model.User;
import com.foltut.backend.security.JWTLoginSucessResponse;
import com.foltut.backend.security.JwtTokenProvider;
import com.foltut.backend.service.MapValidationErrorService;
import com.foltut.backend.service.UserService;
import com.foltut.backend.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.foltut.backend.security.SecurityConstants.TOKEN_PREFIX;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;



    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody UserLoginDTO loginRequest, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX +  tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTLoginSucessResponse(true, jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegisterDTO userRegisterDTO, BindingResult result){
        // Validate passwords match
        userValidator.validate(userRegisterDTO,result);

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null)return errorMap;

        User newUser = userService.registerUser(userRegisterDTO);

        return  new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/changeEmail")
    public Boolean changeEmail(@RequestBody()ChangeEmailRequestDTO changeEmailRequestDTO){
        return userService.changeEmail(changeEmailRequestDTO);
    }

    @PostMapping("/changePassword")
    public Boolean changePassword(@RequestBody()ChangePasswordRequestDTO changePasswordRequestDTO){
        return userService.changePassword(changePasswordRequestDTO);
    }


    @GetMapping("/getUsername")
    public User getUser(){
        return userService.getUsernameFromSecurityContext();
    }
}
