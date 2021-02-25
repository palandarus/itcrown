package ru.itcrown.repositories.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itcrown.models.Document;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentMapper implements RowMapper<Document> {

    @Override
    public Document mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Document(resultSet.getLong("id"),resultSet.getDate("date"), resultSet.getBigDecimal("totalPrice"));
    }
}
