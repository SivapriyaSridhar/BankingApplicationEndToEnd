package com.bankingManagementSystem.endToEnd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "Account_Table")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {

  @Id
  @Column(name = "account_number")
  @GeneratedValue
  private int id;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "customer_Id", nullable = false, updatable = false)
  private Customer customer;

  @Column(name = "account_type")
  private String accountType;

  @Column(name = "balance")
  private int balance;

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}
