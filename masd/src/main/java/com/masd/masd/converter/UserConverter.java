package com.masd.masd.converter;

import com.masd.masd.model.Account;
import com.masd.masd.model.User;
import com.masd.masd.model.dto.AccountDto;
import com.masd.masd.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter implements Converter<User, UserDto> {

    @Autowired
    private AccountConverter accountConverter;

    @Override
    public User convertDtoToModel(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto convertModelToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setAccountDto(getAccounts(user));
        return userDto;
    }

    private List<AccountDto> getAccounts(User user) {
        List<AccountDto> accounts = new ArrayList<>();
        for (Account account : user.getAccounts()) {
            accounts.add(accountConverter.convertModelToDto(account));
        }
        return accounts;
    }
}
