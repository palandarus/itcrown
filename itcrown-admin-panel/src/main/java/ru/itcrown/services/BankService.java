package ru.itcrown.services;

import ru.itcrown.models.Bank;

import java.util.List;

public interface BankService {

    List<Bank> findAll();

    void saveOrUpdate(Bank bank);

    Bank findById(Long id);

    void removeById(Long id);

    Bank findByName(String name);

    Bank findByBik(String bik);
}
