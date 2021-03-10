package ru.itcrown.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itcrown.models.BankAccount;
import ru.itcrown.repositories.BankAccountRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final Map<Long, BankAccount> bankAccountsMap = new ConcurrentHashMap<>();

    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public BankAccount findById(Long id) {
        if (bankAccountsMap.get(id) == null) findAll();
        return bankAccountsMap.get(id);
    }

    @Override
    public void saveOrUpdate(BankAccount bankAccount) {
        bankAccountRepository.save(bankAccount);
        bankAccountsMap.put(bankAccount.getId(), bankAccount);
    }

    @Override
    public BankAccount findByPaymentAccount(String paymentAccount) {
        return bankAccountRepository.findByPaymentAccount(paymentAccount);
    }

    @Override
    public void removeById(Long id) {
        bankAccountRepository.removeById(id);
        bankAccountsMap.remove(id);
    }

    @Override
    public List<BankAccount> findAll() {
        bankAccountsMap.clear();
        bankAccountsMap.putAll(bankAccountRepository.findAll());
        return new ArrayList<BankAccount>(bankAccountsMap.values());
    }
}
