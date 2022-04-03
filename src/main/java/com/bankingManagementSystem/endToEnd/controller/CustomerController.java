package com.bankingManagementSystem.endToEnd.controller;

import com.bankingManagementSystem.endToEnd.entity.Customer;
import com.bankingManagementSystem.endToEnd.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customers")
@RestController
public class CustomerController {

  private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
  @Autowired private CustomerService customerService;

  @PostMapping("/createCustomer")
  public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
    logger.info("\n " + "Customer creation method! " + "\n");
    return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.OK);
  }

  @DeleteMapping("deleteCustomer/{id}")
  public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
    logger.info("\n " + "Customer deletion method! " + "\n");

    return new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK);
  }

  @GetMapping("/getCustomers")
  public ResponseEntity<List<Customer>> getCustomers() {
    logger.info("\n " + "Customer getter method! " + "\n");
    return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
  }

  @GetMapping("/getCustomer/{id}")
  public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
    return new ResponseEntity<>(customerService.getCustomerByID(id), HttpStatus.OK);
  }

  @PutMapping("/updateCustomer")
  public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
    return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);
  }
}
