package ru.itcrown.repositories.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itcrown.models.Bill;
import ru.itcrown.repositories.OrganizationRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillMapper implements RowMapper<Bill> {

    private final OrganizationRepository organizationRepository;


    public BillMapper(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Bill mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Bill(resultSet.getLong("id"), resultSet.getString("number"), resultSet.getDate("billDate"), resultSet.getBigDecimal("totalPrice"), organizationRepository.findById(resultSet.getLong("organizationId")));
    }
}
