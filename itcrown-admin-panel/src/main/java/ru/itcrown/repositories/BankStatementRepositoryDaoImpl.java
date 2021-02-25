package ru.itcrown.repositories;

import org.springframework.stereotype.Component;
import ru.itcrown.models.BankStatement;
import ru.itcrown.repositories.mappers.BankStatementMapper;
import ru.itcrown.services.PaymentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BankStatementRepositoryDaoImpl extends DefaultDaoRepository implements BankStatementRepository {

    private final PaymentService paymentService;

    public BankStatementRepositoryDaoImpl(PaymentService paymentService){
        this.paymentService=paymentService;
    }

    @Override
    public Map<Long, BankStatement> findAll() {
        String SQL="select * from bankStatement";
        List<BankStatement> bankStatementList=jdbcTemplateObject.query(SQL, new BankStatementMapper());
        Map<Long, BankStatement> bankStatementMap=new HashMap<>();
        for(BankStatement bankStatement:bankStatementList){
            bankStatement.setPaymentsList(paymentService.getByBankStatement(bankStatement));
            bankStatementMap.put(bankStatement.getId(), bankStatement);
        }

        return bankStatementMap;
    }

    @Override
    public BankStatement findById(Long id) {
        String SQL="select * from bankStatement where id=?";
        BankStatement tempBankStatement=jdbcTemplateObject.queryForObject(SQL, new BankStatementMapper(), id);
        tempBankStatement.setPaymentsList(paymentService.getByBankStatement(tempBankStatement));
        return tempBankStatement;
    }

    @Override
    public void removeById(Long id) {
        String SQL="delete from bankStatement where id=?";
        jdbcTemplateObject.update(SQL, id);
    }

    @Override
    public void save(BankStatement bankStatement) {
        String SQL;
        if(findById(bankStatement.getId()) == null) SQL="insert into bankStatemnet (dateTime) values(?)";
        else SQL="update bankStatement set dateTime=? where id=?";
        jdbcTemplateObject.update(SQL, bankStatement.getDateTime(), bankStatement.getId());
    }
}
