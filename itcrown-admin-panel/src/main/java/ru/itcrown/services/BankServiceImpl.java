package ru.itcrown.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itcrown.models.Bank;
import ru.itcrown.repositories.BankRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BankServiceImpl implements BankService {
    private final BankRepository bankRepository;
    private final Map<Long, Bank> banksMap = new HashMap<Long, Bank>();

    @Autowired
    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public List<Bank> findAll() {
        Map<Long, Bank> banksMapFromRepository = bankRepository.findAll();
        banksMap.clear();
        banksMap.putAll(banksMapFromRepository);
        return banksMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Bank getBankById(Long id) {
        Bank bank = bankRepository.findById(id);
        if (!banksMap.containsValue(bank)) findAll();
        return bank;
    }

    @Override
    public Bank getBankByName(String name) {
        return bankRepository.findByName(name);
    }

    @Override
    public Bank getBankByBik(String bik) {
        return bankRepository.findByBik(bik);
    }

    @Override
    public void saveOrUpdateBank(Bank bank) {
        bankRepository.save(bank);
        findAll();
    }

    @Override
    public void deleteBankById(Long id) {
        bankRepository.removeById(id);
        banksMap.remove(id);
    }
}
