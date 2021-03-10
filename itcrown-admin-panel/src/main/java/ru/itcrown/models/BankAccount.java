package ru.itcrown.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BankAccount extends AbstractModel{
    private String paymentAccount;
    private Bank bank;
}
