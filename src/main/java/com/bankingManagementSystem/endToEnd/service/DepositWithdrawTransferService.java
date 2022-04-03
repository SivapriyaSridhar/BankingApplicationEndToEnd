package com.bankingManagementSystem.endToEnd.service;

import com.bankingManagementSystem.endToEnd.entity.Account;
import com.bankingManagementSystem.endToEnd.entity.Customer;
import com.bankingManagementSystem.endToEnd.entity.Transaction;
import com.bankingManagementSystem.endToEnd.entity.TransactionType;
import com.bankingManagementSystem.endToEnd.model.TransactionHelper;
import com.bankingManagementSystem.endToEnd.model.TransferBody;
import com.bankingManagementSystem.endToEnd.repository.AccountReposirtory;
import com.bankingManagementSystem.endToEnd.repository.CustomerRepository;
import com.bankingManagementSystem.endToEnd.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DepositWithdrawTransferService {
  @Autowired TransactionRepository transactionRepository;

  @Autowired CustomerRepository customerRepository;

  @Autowired AccountReposirtory accountRepository;

  public String depositAmount(TransactionHelper transactionHelper) {
    int accountNumber = transactionHelper.getAccountNumber();
    if (accountNumber != 0 && accountRepository.existsById(accountNumber)) {
      Account account = accountRepository.findById(accountNumber).get();
      Customer customer = account.getCustomer();
      int amount = transactionHelper.getAmount();
      account.setBalance(account.getBalance() + amount);
      Transaction transaction =
          createTransaction(
              account, amount, LocalDateTime.now(), customer, TransactionType.DEPOSIT);
      transactionRepository.save(transaction);
      return "Amount Deposited Successfully" + transactionRepository.save(transaction);
    } else {
      return "Account Doesn't Exist";
    }
  }

  public String withdrawAmount(TransactionHelper transactionHelper) {
    int account_number = transactionHelper.getAccountNumber();
    if (account_number != 0 && accountRepository.existsById(account_number)) {
      Account account = accountRepository.findById(account_number).get();
      Customer customer = account.getCustomer();
      int amount = transactionHelper.getAmount();
      if (amount > account.getBalance()) {
        return "Not enough balance";
      } else {
        account.setBalance(account.getBalance() - amount);
        //				transaction
        Transaction transaction =
            createTransaction(
                account, amount, LocalDateTime.now(), customer, TransactionType.WITHDRAW);
        transactionRepository.save(transaction);

        return "Amount withdrawn successfully" + transactionRepository.save(transaction);
      }
    } else {
      return "Account doesnt exist";
    }
  }

  public String transferAmount(TransferBody body) {
    int fromAccountNumber = body.getFromAccountNumber();
    int toAccountNumber = body.getToAccountNumber();
    if (fromAccountNumber != 0
        && toAccountNumber != 0
        && accountRepository.existsById(fromAccountNumber)
        && accountRepository.existsById(toAccountNumber)) {
      Account fromAccount = accountRepository.findById(fromAccountNumber).get();
      int amount = body.getAmount();
      if (amount > fromAccount.getBalance()) {
        return "Not enough balance to transfer";
      } else {
        Account toAccount = accountRepository.findById(toAccountNumber).get();
        Customer customer = fromAccount.getCustomer();
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        Transaction transaction =
            createTransaction(
                fromAccount, amount, LocalDateTime.now(), customer, TransactionType.TRANSFER);
        transactionRepository.save(transaction);

        return "Amount transferred successfully" + transactionRepository.save(transaction);
      }
    } else {
      return "Incorrect account detail";
    }
  }

  public Transaction createTransaction(
      Account account,
      int amount,
      LocalDateTime localDateTime,
      Customer customer,
      TransactionType transactionType) {
    Transaction newTransaction = new Transaction();
    newTransaction.setAccount(account);
    newTransaction.setAmount(amount);
    newTransaction.setTransactionDatetime(LocalDateTime.now());
    newTransaction.setTransactionDoneBy(customer.getFirstName() + " " + customer.getLastName());
    newTransaction.setTransactionType(transactionType);
    return newTransaction;
  }

  public List<Transaction> getAllTransactions() {
    return (List<Transaction>) transactionRepository.findAll();
  }
}
