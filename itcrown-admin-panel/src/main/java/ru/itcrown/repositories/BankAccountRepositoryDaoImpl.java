package ru.itcrown.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itcrown.models.BankAccount;
import ru.itcrown.repositories.mappers.BankAccountMapper;
import ru.itcrown.services.BankService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BankAccountRepositoryDaoImpl extends DefaultDaoRepository implements BankAccountRepository {

    private final BankService bankService;

    @Autowired
    public BankAccountRepositoryDaoImpl(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public Map<Long, BankAccount> findAll() {
        String SQL = "select * from BankAccount";
        List<BankAccount> bankAccounts = jdbcTemplateObject.query(SQL, new BankAccountMapper(bankService));
        Map<Long, BankAccount> resultMap = new HashMap<>();
        for (BankAccount bankAccount : bankAccounts) {
            resultMap.put(bankAccount.getId(), bankAccount);
        }
        return resultMap;
    }

    @Override
    public BankAccount findById(Long id) {
        String SQL = "select * from BankAccount where id= :id";
        BankAccount result = jdbcTemplateObject.queryForObject(SQL, new BankAccountMapper(bankService), id);
        return result;
    }

    @Override
    public void save(BankAccount bankAccount) {
        String SQL;
        if (findById(bankAccount.getId()) != null)
            SQL = "update bankAccount set paymentAccount=?, set bank_id=? where id=?";
        else SQL = "insert into bankAccount (paymentAccount, bank_id) values(?,?)";
        jdbcTemplateObject.update(SQL, bankAccount.getPaymentAccount(), bankAccount.getBank().getId(),bankAccount.getId());
    }

    @Override
    public void removeById(Long id) {
        String SQL = "delete from bankAccount where id=?";
        if (findById(id) != null) jdbcTemplateObject.update(SQL, id);
    }

    @Override
    public BankAccount findByPaymentAccount(String paymentAccount) {
        String SQL = "select * from bankAccount where paymentAccount=?";
        return jdbcTemplateObject.queryForObject(SQL, new BankAccountMapper(bankService), paymentAccount);
    }
}
