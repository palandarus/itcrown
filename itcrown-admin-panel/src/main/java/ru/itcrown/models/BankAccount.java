package ru.itcrown.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class BankAccount extends AbstractModel{
    private String paymentAccount;
    private Bank bank;
}
