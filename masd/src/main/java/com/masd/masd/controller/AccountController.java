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

    @DeleteMapping(value = "/{accountId}")
    public ResponseEntity deleteAccount(@PathVariable int accountId) {
        boolean deleted = accountService.deleteAccount(accountId);
        ResponseEntity responseEntity = null;
        if (deleted == Boolean.TRUE) {
            responseEntity = ResponseEntity.status(HttpStatus.OK).build();
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return responseEntity;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity changeAccountAmount(@PathVariable int id, @RequestParam double amount){

        if(amount < 1 ){
            return ResponseEntity.of(Optional.of(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.ok(accountService.updateAccountAmount(id, amount));
    }
}
