package com.bankingManagementSystem.endToEnd.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "transaction_type")
  private TransactionType transactionType;

  private int amount;

  @Column(name = "transaction_done_by")
  private String transactionDoneBy;

  @Column(name = "transaction_date_time")
  private LocalDateTime transactionDatetime;

  @ManyToOne
  @JoinColumn(name = "account_number")
  private Account account;

  public Transaction() {}

  public Transaction(
      TransactionType transactionType,
      int amount,
      LocalDateTime transactionDatetime,
      String transactionDoneBy) {
    this.transactionType = transactionType;
    this.amount = amount;
    this.transactionDatetime = transactionDatetime;
    this.transactionDoneBy = transactionDoneBy;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public TransactionType getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(TransactionType transactionType) {
    this.transactionType = transactionType;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public LocalDateTime getTransactionDatetime() {
    return transactionDatetime;
  }

  public void setTransactionDatetime(LocalDateTime transactionDatetime) {
    this.transactionDatetime = transactionDatetime;
  }

  public String getTransactionDoneBy() {
    return transactionDoneBy;
  }

  public void setTransactionDoneBy(String transactionDoneBy) {
    this.transactionDoneBy = transactionDoneBy;
  }

  @Override
  public String toString() {
    return "Transaction [id="
        + id
        + ", transactionType="
        + transactionType
        + ", amount="
        + amount
        + ", transactionDatetime="
        + transactionDatetime
        + ", transactionDoneBy="
        + transactionDoneBy
        + "]";
  }
}
