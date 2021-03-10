package ru.itcrown.repositories.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itcrown.models.BankAccount;
import ru.itcrown.repositories.BankRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

@RequiredArgsConstructor
@Component
public class BankAccountMapper implements RowMapper<BankAccount> {

    private final BankRepository bankRepository;


    @Override
    public BankAccount mapRow(ResultSet resultSet, int i) throws SQLException {
        BankAccount resultBankAccount = new BankAccount();
        resultBankAccount.setId(resultSet.getLong("id"));
        resultBankAccount.setPaymentAccount(resultSet.getString("name"));
        resultBankAccount.setBank(bankRepository.findById(Long.parseLong(resultSet.getString("bankId"))));
        return resultBankAccount;
    }


}
