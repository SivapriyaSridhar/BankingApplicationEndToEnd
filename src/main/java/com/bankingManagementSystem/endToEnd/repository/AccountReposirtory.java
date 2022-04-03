package com.bankingManagementSystem.endToEnd.repository;

import com.bankingManagementSystem.endToEnd.entity.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountReposirtory extends CrudRepository<Account, Integer> {
  @Query("select count(*) from Account where customer_id = :id")
  int customerCount(@Param("id") int id);
}
