package ru.itcrown.repositories.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itcrown.models.Usluga;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UslugaMapper implements RowMapper<Usluga> {

    @Override
    public Usluga mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}
