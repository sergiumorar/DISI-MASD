package com.masd.masd.controller;

import com.masd.masd.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @PutMapping(value = "/{id}")
    public ResponseEntity changeAccountAmount(@PathVariable int id, @RequestParam double amount){

        if(amount < 1 ){
            return ResponseEntity.of(Optional.of(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.ok(accountService.updateAccountAmount(id, amount));
    }
}
