package ru.itcrown.repositories.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itcrown.models.Bank;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BankMapper implements RowMapper<Bank> {

    @Override
    public Bank mapRow(ResultSet resultSet, int i) throws SQLException {
        Bank resultBank = new Bank();
        resultBank.setId(resultSet.getLong("id"));
        resultBank.setBik(resultSet.getString("bik"));
        resultBank.setCorrespondentAccount(resultSet.getString("correspondentAccount"));
        resultBank.setName(resultSet.getString("name"));
        return resultBank;

    }
}
