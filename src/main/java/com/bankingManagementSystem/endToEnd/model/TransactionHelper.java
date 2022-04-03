package com.bankingManagementSystem.endToEnd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHelper {

  private int accountNumber;

  @Min(value = 1)
  private int amount;
}
