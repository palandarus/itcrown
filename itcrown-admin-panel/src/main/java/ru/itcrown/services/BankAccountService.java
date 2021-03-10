package ru.itcrown.services;

import ru.itcrown.models.BankAccount;

import java.util.List;

public interface BankAccountService {

    List<BankAccount> findAll();


    void saveOrUpdate(BankAccount bankAccount);

    BankAccount findByPaymentAccount(String paymentAccount);

    void removeById(Long id);

    BankAccount findById(Long id);
}
