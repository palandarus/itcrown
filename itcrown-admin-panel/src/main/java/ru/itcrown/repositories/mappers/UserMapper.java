package ru.itcrown.repositories.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itcrown.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        return new User(resultSet.getLong("id"), resultSet.getString("username"), resultSet.getString("password"),
                resultSet.getDate("birthdate"), resultSet.getString("address"), resultSet.getString("description"),
                resultSet.getString("firstName"), resultSet.getString("lastName"), resultSet.getString("email"),
                resultSet.getString("phone"));
    }
}
