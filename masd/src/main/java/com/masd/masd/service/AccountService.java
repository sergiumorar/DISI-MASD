package com.masd.masd.service;

import com.masd.masd.model.Account;
import com.masd.masd.repository.JpaAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Marina Baban
 */
@Service
public class AccountService {
    @Autowired
    private JpaAccountRepository accountRepository;

    public void deleteAccount(int accountId){
        accountRepository.deleteById(accountId);
    }
}
