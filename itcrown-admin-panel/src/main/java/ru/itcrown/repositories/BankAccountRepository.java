package ru.itcrown.repositories;

import ru.itcrown.models.BankAccount;

import javax.swing.tree.RowMapper;
import java.sql.ResultSet;
import java.util.List;

public interface BankAccountRepository {
        List<BankAccount> findAll();
        BankAccount findById(Long id);
        BankAccount save(BankAccount bankAccount);
        void removeById(Long id);
}
