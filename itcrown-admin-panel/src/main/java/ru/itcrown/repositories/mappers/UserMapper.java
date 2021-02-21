package ru.itcrown.repositories.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itcrown.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}
