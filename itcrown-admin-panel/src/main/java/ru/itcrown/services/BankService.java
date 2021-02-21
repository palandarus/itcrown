package ru.itcrown.services;

import ru.itcrown.models.Bank;

import java.util.List;

public interface BankService {

    List<Bank> findAll();
    Bank findById(Long id) throws Exception;
    Bank save(Bank bank);
    void removeById(Long id);

}
