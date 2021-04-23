package com.upgrad.phonedirectory.service;

import com.upgrad.phonedirectory.model.User;
import com.upgrad.phonedirectory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.AuthProvider;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Contain all the business logic and communicate to db
    public User login(User user) {
        User existingUser = userRepository.checkCredentials(user.getUsername());
        if(existingUser!=null){
            if(!passwordEncoder.matches(user.getPassword(),existingUser.getPassword())) {
                return null;
            } else {
                return existingUser;
            }
        } else return null;
    }

    public boolean registerUser(User userToEncrpyt) {

        User newUser = new User();
        newUser.setUsername(userToEncrpyt.getUsername());
        newUser.setEmail(userToEncrpyt.getEmail());
        newUser.setPhonenum(userToEncrpyt.getPhonenum());
        newUser.setPassword(passwordEncoder.encode(userToEncrpyt.getPassword()));
        return userRepository.registerUser(newUser);
    }
}
