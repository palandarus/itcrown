package ru.itcrown.repositories.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itcrown.models.Bill;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillMapper implements RowMapper<Bill> {

    @Override
    public Bill mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}
