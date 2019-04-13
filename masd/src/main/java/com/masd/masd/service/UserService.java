package com.masd.masd.service;

import com.masd.masd.converter.UserConverter;
import com.masd.masd.model.User;
import com.masd.masd.model.dto.UserDto;
import com.masd.masd.model.dto.UserLoginDto;
import com.masd.masd.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private JpaUserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    public UserDto login(UserLoginDto userData) {
        final User user = userRepository.findByUsernameAndPassword(userData.getUsername(), userData.getPassword());
        return user == null ? null : userConverter.convertModelToDto(user);
    }
}
