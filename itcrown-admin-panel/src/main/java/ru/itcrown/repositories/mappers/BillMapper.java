package ru.itcrown.repositories.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itcrown.models.Bill;
import ru.itcrown.services.OrganizationService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillMapper implements RowMapper<Bill> {

    private final OrganizationService organizationService;


    public BillMapper(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @Override
    public Bill mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Bill(resultSet.getLong("id"),resultSet.getString("number"), resultSet.getDate("billDate"), resultSet.getBigDecimal("totalPrice"), organizationService.findById(resultSet.getLong("organizationId")));
    }
}
