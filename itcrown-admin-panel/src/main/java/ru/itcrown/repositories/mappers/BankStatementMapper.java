package ru.itcrown.repositories.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itcrown.models.BankStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BankStatementMapper implements RowMapper<BankStatement> {
    @Override
    public BankStatement mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}
