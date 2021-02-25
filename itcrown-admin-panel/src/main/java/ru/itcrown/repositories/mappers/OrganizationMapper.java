package ru.itcrown.repositories.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itcrown.models.Organization;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganizationMapper implements RowMapper<Organization> {

    @Override
    public Organization mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Organization(resultSet.getLong("id"),resultSet.getString("name"),
                resultSet.getString("director"), resultSet.getString("accountant"),
                resultSet.getString("inn"), resultSet.getString("ksk"));
    }
}
