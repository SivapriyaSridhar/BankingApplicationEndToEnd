package com.bankingManagementSystem.endToEnd.controller;

import com.bankingManagementSystem.endToEnd.entity.Transaction;
import com.bankingManagementSystem.endToEnd.model.TransactionHelper;
import com.bankingManagementSystem.endToEnd.model.TransferBody;
import com.bankingManagementSystem.endToEnd.service.DepositWithdrawTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

  @Autowired DepositWithdrawTransferService transactionService;

  @PostMapping("/deposit")
  public ResponseEntity<String> depositAmount(@RequestBody TransactionHelper transactionHelper) {
    return new ResponseEntity<>(transactionService.depositAmount(transactionHelper), HttpStatus.OK);
  }

  @PostMapping("/withdraw")
  public ResponseEntity<String> withdrawAmount(@RequestBody TransactionHelper transactionHelper) {
    return new ResponseEntity<>(
        transactionService.withdrawAmount(transactionHelper), HttpStatus.OK);
  }

  @PostMapping("/transfer")
  public ResponseEntity<String> transferAmount(@RequestBody TransferBody transferBody) {
    return new ResponseEntity<>(transactionService.transferAmount(transferBody), HttpStatus.OK);
  }

  @GetMapping("/getAllTransactions")
  public ResponseEntity<List<Transaction>> getAllTransactions() {
    return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
  }
}
