package ru.itcrown.repositories;

import ru.itcrown.models.BankStatement;

import java.util.Map;

public interface BankStatementRepository {

    Map<Long, BankStatement> findAll();
    BankStatement findById(Long id);
    void removeById(Long id);
    void save(BankStatement bankStatement);

}
