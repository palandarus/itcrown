package ru.itcrown.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itcrown.models.BankStatement;
import ru.itcrown.repositories.BankStatementRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


@Service
public class BankStatementServiceImpl implements BankStatementService {

    private final BankStatementRepository bankStatementRepository;
    private Map<Long, BankStatement> bankStatementMap = new ConcurrentHashMap<>();

    @Autowired
    public BankStatementServiceImpl(BankStatementRepository bankStatementRepository) {
        this.bankStatementRepository = bankStatementRepository;
    }

    @Override
    public List<BankStatement> findAll() {
        bankStatementMap.clear();
        bankStatementMap = bankStatementRepository.findAll();
        return bankStatementMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public BankStatement getBankStatementById(Long id) {
        if(bankStatementMap.get(id)!=null) return bankStatementMap.get(id);
        else{
            findAll();
            return bankStatementMap.get(id);
        }
    }



    @Override
    public void saveOrUpdateBankStatement(BankStatement bankStatement) {
        bankStatementRepository.save(bankStatement);
        if(bankStatementMap.containsValue(bankStatement)) bankStatementMap.put(bankStatement.getId(),bankStatement);
        else findAll();
    }

    @Override
    public void deleteBankStatementById(Long id) {
        bankStatementRepository.removeById(id);
        if(bankStatementMap.get(id)!=null) bankStatementMap.remove(id);
        findAll();
    }
}
