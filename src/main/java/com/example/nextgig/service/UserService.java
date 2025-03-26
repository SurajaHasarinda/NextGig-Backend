package com.example.nextgig.service;

import com.example.nextgig.dto.UserDTO;
import com.example.nextgig.model.User;
import com.example.nextgig.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private UserDTO convertToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .pictureUrl(user.getPictureUrl())
                .googleId(user.getGoogleId())
                .build();
    }
}