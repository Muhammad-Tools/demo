package com.example;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor Injection (Cleaner than @Autowired)
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String registerUser(User user) {
        // 1. Check if username exists
        if (userRepository.existsByUsername(user.getUsername())) {
            return "Error: Username is already taken!";
        }

        // 2. Check if email exists
        if (userRepository.existsByEmail(user.getEmail())) {
            return "Error: Email is already in use!";
        }

        // 3. Encrypt the raw password before saving it to the DB
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        // 4. Save the user
        userRepository.save(user);
        return "User registered successfully!";
    }
}