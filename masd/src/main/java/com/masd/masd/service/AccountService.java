package com.masd.masd.service;

import com.masd.masd.converter.AccountConverter;
import com.masd.masd.model.Account;
import com.masd.masd.model.dto.AccountDto;
import com.masd.masd.repository.JpaAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Marina Baban
 */
@Service
public class AccountService {
    @Autowired
    private JpaAccountRepository accountRepository;

    @Autowired
    private AccountConverter accountConverter;

    public boolean deleteAccount(int accountId) {
        try {
            accountRepository.deleteById(accountId);
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    public AccountDto updateAccountAmount(int id, double amount) {

        Optional<Account> account = accountRepository.findById(id);

        if (!account.isPresent()) {
            return null;
        } else {
            final Account persistedAccount = account.get();
            persistedAccount.setAmount(amount);
            accountRepository.save(persistedAccount);
            return accountConverter.convertModelToDto(persistedAccount);
        }
    }
}
