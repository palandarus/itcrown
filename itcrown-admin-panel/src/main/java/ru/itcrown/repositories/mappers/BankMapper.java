package ru.itcrown.repositories.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itcrown.models.Bank;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BankMapper implements RowMapper<Bank> {

    @Override
    public Bank mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Bank(resultSet.getString("name"), resultSet.getString("correspondentAccount"), resultSet.getString("bik"));
    }
}
