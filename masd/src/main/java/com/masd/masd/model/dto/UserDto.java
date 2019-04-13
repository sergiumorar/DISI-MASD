package com.masd.masd.model.dto;

import java.util.List;

public class UserDto {

    private int id;
    private List<AccountDto> accountDto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<AccountDto> getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(List<AccountDto> accountDto) {
        this.accountDto = accountDto;
    }
}
