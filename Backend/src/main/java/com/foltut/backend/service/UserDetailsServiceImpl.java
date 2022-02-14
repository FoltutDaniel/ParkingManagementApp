package com.foltut.backend.service;

import com.foltut.backend.model.User;
import com.foltut.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        Optional<User> user = userRepository.findByUsername(username);
        if(!user.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }
        return user.get();
    }


    @Transactional
    public User loadUserById(Long id){
        Optional<User> user = userRepository.getById(id);
        if(!user.isPresent()){
            throw new UsernameNotFoundException("User not found");
        }
        return user.get();
    }
}
