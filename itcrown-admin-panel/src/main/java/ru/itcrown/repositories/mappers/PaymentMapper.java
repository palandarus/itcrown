package ru.itcrown.repositories.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itcrown.models.Payment;
import ru.itcrown.repositories.BankStatementRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentMapper implements RowMapper<Payment> {

    private final BankStatementRepository bankStatementRepository;

    public PaymentMapper(BankStatementRepository bankStatementRepository) {
        this.bankStatementRepository = bankStatementRepository;
    }

    @Override
    public Payment mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Payment(resultSet.getLong("id"), resultSet.getDate("dateTime"), resultSet.getString("number"),
                resultSet.getString("inn"), resultSet.getString("clientName"), resultSet.getString("comment"),
                bankStatementRepository.findById(resultSet.getLong("banlStatementId")));
    }
}
