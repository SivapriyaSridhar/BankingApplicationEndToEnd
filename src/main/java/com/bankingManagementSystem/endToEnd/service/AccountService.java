package com.bankingManagementSystem.endToEnd.service;

import com.bankingManagementSystem.endToEnd.entity.Account;
import com.bankingManagementSystem.endToEnd.entity.Customer;
import com.bankingManagementSystem.endToEnd.repository.AccountReposirtory;
import com.bankingManagementSystem.endToEnd.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AccountService {
  @Autowired AccountReposirtory accountRepository;

  @Autowired CustomerRepository customerRepository;

  public String createAccount(Account account) {

    int customer_id = account.getCustomer().getId();
    if (!customerRepository.existsById(customer_id)) {
      return "Customer is not present";
    } else if (accountRepository.customerCount(customer_id) == 0) {
      accountRepository.save(account);
      return "Account created successfully! " + account.getId() + " is your id value!";
    } else {

      return "Account already exist for this customer";
    }
  }

  public String updateAccount(Account account) {
    Optional<Account> optionalAccount = accountRepository.findById(account.getId());

    if (optionalAccount.isPresent()) {
      Account oldAccount = optionalAccount.get();
      //			if(oldAccount.equals(null)){
      //
      //			}
      oldAccount.setAccountType(account.getAccountType());
      oldAccount.setBalance(account.getBalance());
      Customer customer = new Customer();
      customer.setId(account.getCustomer().getId());
      oldAccount.setCustomer(customer);
      oldAccount.setId(account.getId());
      accountRepository.save(oldAccount);
      return "Updated Successfully!";
    } else {
      throw new NoSuchElementException("No such id present!");
    }
  }

  public String deleteAccount(int id) {
    if (accountRepository.existsById(id)) {
      accountRepository.deleteById(id);
      return "Account Deleted Successfully";
    } else {
      return "Invalid account Id!";
    }
  }

  public List<Account> getAccounts() {
    return (List<Account>) accountRepository.findAll();
  }

  public Account getAccountById(int id) {
    return accountRepository
        .findById(id)
        .orElseThrow(() -> new NoSuchElementException("No such id found!"));
  }
}
