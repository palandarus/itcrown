package ru.itcrown.services;

import ru.itcrown.models.Bank;

import java.util.List;

public interface BankService {

    List<Bank> findAll();

    Bank getBankById(Long id);


    void saveOrUpdate(Bank bank);

    Bank findById(Long id);

    void removeById(Long id);
}
