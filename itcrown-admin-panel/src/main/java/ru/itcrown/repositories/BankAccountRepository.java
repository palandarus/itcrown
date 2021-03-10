package ru.itcrown.repositories;

import ru.itcrown.models.BankAccount;

import java.util.Map;

public interface BankAccountRepository {
        Map<Long, BankAccount> findAll();
        BankAccount findById(Long id);
        BankAccount findByPaymentAccount(String paymentAccount);
        void save(BankAccount bankAccount);
        void removeById(Long id);
}
