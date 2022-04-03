package com.bankingManagementSystem.endToEnd.repository;

import com.bankingManagementSystem.endToEnd.entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {}
