package ru.itcrown.services;

import ru.itcrown.models.BankAccount;

import java.util.List;

public interface BankAccountService {

    List<BankAccount> findAll();

    BankAccount getBankAccountById(Long id);

    void saveOrUpdateBankAccount(BankAccount bankAccount);

    BankAccount getBankAccountByPaymentAccount(String paymentAccount);

    void deleteBankAccountById(Long id);

}
