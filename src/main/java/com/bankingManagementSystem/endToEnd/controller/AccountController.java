package com.bankingManagementSystem.endToEnd.controller;

import com.bankingManagementSystem.endToEnd.entity.Account;
import com.bankingManagementSystem.endToEnd.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
  @Autowired AccountService accountService;

  @PostMapping("/createAccount")
  public ResponseEntity<String> createAccount(@RequestBody Account account) {
    return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.OK);
  }

  @PutMapping("/updateAccount")
  public ResponseEntity<String> updateAccount(@RequestBody Account account) {
    return new ResponseEntity<>(accountService.updateAccount(account), HttpStatus.OK);
  }

  @DeleteMapping("/deleteAccount/{id}")
  public ResponseEntity<String> deleteAccount(@PathVariable int id) {
    return new ResponseEntity<>(accountService.deleteAccount(id), HttpStatus.OK);
  }

  @GetMapping("/getAllAccounts")
  public ResponseEntity<List<Account>> getAccounts() {
    return new ResponseEntity<>(accountService.getAccounts(), HttpStatus.OK);
  }

  @GetMapping("/getAccount/{id}")
  public ResponseEntity<Account> getAccountById(@PathVariable int id) {
    return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
  }
}
