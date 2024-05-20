package com.example.synchronyproject.service;

import com.example.synchronyproject.model.Image;
import com.example.synchronyproject.model.User;
import com.example.synchronyproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUserImage(Long id, String imageUrl) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            boolean imageExists = user.getImages().stream()
                    .anyMatch(image -> image.getImageUrl().equals(imageUrl));
            if (!imageExists) {
                Image image = new Image(imageUrl);
                image.setUser(user);
                user.addImage(image);
                userRepository.save(user);
            }
        } else {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
    }

    public void removeUserImage(Long userId, Long imageId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Optional<Image> optionalImage = user.getImages().stream()
                    .filter(image -> image.getId().equals(imageId))
                    .findFirst();
            optionalImage.ifPresent(image -> {
                user.removeImage(image);
                userRepository.save(user);
            });
        } else {
            throw new IllegalArgumentException("User not found with id: " + userId);
        }
    }

    public Image findImageById(Long imageId) {
        return userRepository.findAll().stream()
                .flatMap(user -> user.getImages().stream())
                .filter(image -> image.getId().equals(imageId))
                .findFirst()
                .orElse(null);
    }

    // New method to get all images for a user by user ID
    public List<Image> getUserImages(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            return optionalUser.get().getImages();
        } else {
            throw new IllegalArgumentException("User not found with id: " + userId);
        }
    }
}