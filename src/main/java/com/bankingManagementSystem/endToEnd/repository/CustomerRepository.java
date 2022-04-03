package com.bankingManagementSystem.endToEnd.repository;

import com.bankingManagementSystem.endToEnd.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

  //  List<Customer> findByEmail(String email);
  //	String findByCustomerName(@Param("name") String fName);

  //	@Query("from Customer where firstName = :name")

}
