package ru.itcrown.services;

import org.springframework.stereotype.Component;
import ru.itcrown.models.Bank;
import ru.itcrown.repositories.BankRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class BankServiceImpl implements BankService {
    private BankRepository bankRepository;
     List<Bank> bankLists=new ArrayList<>();

    @Override
    public List<Bank> findAll() {
        List<Bank> bankListsFromRepository=bankRepository.findAll();
        if(!bankLists.isEmpty() && bankLists.containsAll(bankListsFromRepository)) return bankLists;
        else {
            bankLists.clear();
            bankLists.addAll(bankListsFromRepository);
        }
    }

    @Override
    public Bank findById(Long id) throws Exception {
        Bank tempBank=new Bank(id);
        if(bankLists.contains(tempBank)) return bankLists.get(bankLists.indexOf(tempBank));
        else{
            findAll();
            if(!bankLists.contains(tempBank)) throw new Exception("Bank does not exist with id= "+id.toString());
            else return bankLists.get(bankLists.indexOf(tempBank));
        }
    }

    @Override
    public Bank save(Bank bank) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }
}
