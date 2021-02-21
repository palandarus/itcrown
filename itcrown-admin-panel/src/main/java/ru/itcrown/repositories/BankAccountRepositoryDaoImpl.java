package ru.itcrown.repositories;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itcrown.models.BankAccount;
import ru.itcrown.repositories.mappers.BankAccountMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class BankAccountRepositoryDaoImpl extends DefaultDaoRepository implements BankAccountRepository {





    @Override
    public List<BankAccount> findAll() {
        String SQL = "select * from Student";
        List <BankAccount> bankAccounts = jdbcTemplateObject.query(SQL, new BankAccountMapper());
        return bankAccounts;
    }

    @Override
    public BankAccount findById(Long id) {
        return null;
    }

    @Override
    public BankAccount save(BankAccount bankAccount) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }
}
