package com.masd.masd.controller;

import com.masd.masd.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Marina Baban
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @DeleteMapping(value = "/accountId")
    public void deleteAccount(@PathVariable int accountId){
        accountService.deleteAccount(accountId);
    }
}
