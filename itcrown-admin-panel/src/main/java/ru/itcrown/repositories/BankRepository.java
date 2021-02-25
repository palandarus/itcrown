package ru.itcrown.repositories;

import ru.itcrown.models.Bank;

import java.util.Map;

public interface BankRepository {

    Map<Long, Bank> findAll();
    Bank findById(Long id);
    Bank findByBik(String bik);
    void save(Bank bank);
    void removeById(Long id);
    Bank findByName(String name);
}
