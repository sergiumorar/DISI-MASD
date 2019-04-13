package com.masd.masd.service;

import com.masd.masd.converter.AccountConverter;
import com.masd.masd.converter.UserConverter;
import com.masd.masd.model.User;
import com.masd.masd.model.dto.AccountDto;
import com.masd.masd.model.dto.UserDto;
import com.masd.masd.model.dto.UserLoginDto;
import com.masd.masd.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private JpaUserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private AccountConverter accountConverter;

    public UserDto login(UserLoginDto userData) {
        final User user = userRepository.findByUsernameAndPassword(userData.getUsername(), userData.getPassword());
        return user == null ? null : userConverter.convertModelToDto(user);
    }

    public List<AccountDto> getUserAccounts(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(userValue -> userValue.getAccounts().stream()
                .map(this.accountConverter::convertModelToDto)
                .collect(Collectors.toList())).orElse(Collections.emptyList());
    }
}
