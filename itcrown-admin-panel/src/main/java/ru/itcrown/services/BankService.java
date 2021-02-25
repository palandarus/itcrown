package ru.itcrown.services;

import ru.itcrown.models.Bank;

import java.util.List;

public interface BankService {

    List<Bank> findAll();

    Bank getBankById(Long id);

    Bank getBankByName(String name);

    Bank getBankByBik(String bik);

    void saveOrUpdateBank(Bank bank);

    void deleteBankById(Long id);

}
