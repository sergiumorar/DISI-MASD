package com.masd.masd.converter;

import com.masd.masd.model.Account;
import com.masd.masd.model.dto.AccountDto;
import org.springframework.stereotype.Component;

@Component
public class AccountConverter implements Converter<Account, AccountDto> {
    @Override
    public Account convertDtoToModel(AccountDto accountDto) {
        return null;
    }

    @Override
    public AccountDto convertModelToDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setAmount(account.getAmount());
        accountDto.setCurrency(account.getCurrency().getName());
        accountDto.setName(account.getName());
        accountDto.setType(account.getType().getName());
        return accountDto;
    }
}
