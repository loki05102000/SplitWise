package com.lokesh.splitwise.services;

import com.lokesh.splitwise.Exception.UserNotFoundException;
import com.lokesh.splitwise.models.User;
import com.lokesh.splitwise.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User signUp(String name, String email, String passwoed) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        User savedUser = null;
        if(optionalUser.isPresent()){
            throw new UserNotFoundException("User already exist with this Email " + email + " Please Login");
        }
        else {
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(bCryptPasswordEncoder.encode(passwoed));
            savedUser = userRepository.save(user);
        }
        return savedUser;
    }
}
