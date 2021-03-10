package ru.itcrown.services;

import ru.itcrown.models.BankStatement;

import java.util.List;

public interface BankStatementService {
    List<BankStatement> findAll();

    BankStatement getBankStatementById(Long id);


    void saveOrUpdateBankStatement(BankStatement bank);

    void deleteBankStatementById(Long id);
}
