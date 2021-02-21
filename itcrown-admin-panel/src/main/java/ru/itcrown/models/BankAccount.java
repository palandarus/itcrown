package ru.itcrown.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BankAccount extends AbstractModel{
    private String paymentAccount;
    private Bank bank;
}
