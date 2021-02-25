package ru.itcrown.repositories.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itcrown.models.BankAccount;
import ru.itcrown.services.BankService;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BankAccountMapper implements RowMapper<BankAccount> {

    private final BankService bankService;


    public BankAccountMapper(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public BankAccount mapRow(ResultSet resultSet, int i) throws SQLException {
        return new BankAccount(resultSet.getString("name"),
                bankService.getBankById(Long.parseLong(resultSet.getString("bankId"))));
    }


}
