package com.bankingManagementSystem.endToEnd.service;

import com.bankingManagementSystem.endToEnd.entity.Customer;
import com.bankingManagementSystem.endToEnd.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerService {

  @Autowired private CustomerRepository customerRepository;

  public Customer createCustomer(Customer customer) {
    return customerRepository.save(customer);
  }

  public String deleteCustomer(int id) {
    if (customerRepository.existsById(id)) {
      customerRepository.deleteById(id);
      return id + " got deleted Successfully";
    } else {
      return "Customer id: " + id + " not found!";
    }
  }

  public List<Customer> getCustomers() {
    return (List<Customer>) customerRepository.findAll();
  }

  public Customer updateCustomer(Customer customer) {

    Optional<Customer> optionalCustomer = customerRepository.findById(customer.getId());
    Customer oldCustomer = optionalCustomer.get();
    if (optionalCustomer.isPresent()) {
      oldCustomer.setAge(customer.getAge());
      oldCustomer.setEmail(customer.getEmail());
      oldCustomer.setFirstName(customer.getFirstName());
      oldCustomer.setLastName(customer.getLastName());
      oldCustomer.setPhone(customer.getPhone());
      oldCustomer.setAddress(customer.getAddress());
      customerRepository.save(oldCustomer);
    } else {
      return new Customer();
    }
    return oldCustomer;
  }

  public Customer getCustomerByID(int id) {
    return customerRepository
        .findById(id)
        .orElseThrow(() -> new NoSuchElementException("No such id found!"));
  }
}
