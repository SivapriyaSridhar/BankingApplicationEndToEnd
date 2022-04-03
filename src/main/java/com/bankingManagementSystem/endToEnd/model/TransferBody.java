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
public class TransferBody {
  private int fromAccountNumber;
  private int toAccountNumber;

  @Min(value = 1, message = "Amount should not be less than or equal to zero")
  private int amount;
}
