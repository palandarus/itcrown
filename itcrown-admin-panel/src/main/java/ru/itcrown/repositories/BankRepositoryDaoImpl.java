package ru.itcrown.repositories;


import org.springframework.stereotype.Component;
import ru.itcrown.models.Bank;
import ru.itcrown.repositories.mappers.BankMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BankRepositoryDaoImpl extends DefaultDaoRepository implements BankRepository{

    @Override
    public Map<Long, Bank> findAll() {
        String SQL="select * from bank";
        List<Bank> bankList= jdbcTemplateObject.query(SQL, new BankMapper());
        Map<Long, Bank> bankMap=new HashMap<>();
        for (Bank bank:bankList){
            bankMap.put(bank.getId(), bank);
        }
        return bankMap;
    }

    @Override
    public Bank findById(Long id) {
        String SQL="select * from bank where id=?";
        return jdbcTemplateObject.queryForObject(SQL, new BankMapper(),id);
    }

    @Override
    public void save(Bank bank) {
        String SQL;
        if(findById(bank.getId()) == null) SQL="insert into bank (name, correspondentAccount, bik) values(?,?,?,?)";
        else SQL="update bank set name=?, set correspondentAccount=?, set bik=? where id=?";
        jdbcTemplateObject.update(SQL, bank.getName(),bank.getCorrespondentAccount(), bank.getBik(), bank.getId());
    }

    @Override
    public void removeById(Long id) {
        String SQL = "delete from bank where id=?";
        if (findById(id) != null)  jdbcTemplateObject.update(SQL, id);
    }

    @Override
    public Bank findByBik(String bik) {
        String SQL="select * from bank where bik=?";
        return jdbcTemplateObject.queryForObject(SQL, new BankMapper(),bik);
    }

    @Override
    public Bank findByName(String name) {
        String SQL="select * from bank where name=?";
        return jdbcTemplateObject.queryForObject(SQL, new BankMapper(),name);
    }
}
