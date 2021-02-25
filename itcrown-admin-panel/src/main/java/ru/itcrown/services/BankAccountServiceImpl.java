package ru.itcrown.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itcrown.models.BankAccount;
import ru.itcrown.repositories.BankAccountRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final Map<Long, BankAccount> bankAccountsMap = new HashMap<>();

    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public BankAccount getBankAccountById(Long id) {
        if (bankAccountsMap.get(id) == null) findAll();
        return bankAccountsMap.get(id);
    }

    @Override
    public void saveOrUpdateBankAccount(BankAccount bankAccount) {
        bankAccountRepository.save(bankAccount);
        bankAccountsMap.put(bankAccount.getId(), bankAccount);
    }

    @Override
    public BankAccount getBankAccountByPaymentAccount(String paymentAccount) {
        return bankAccountRepository.findByPaymentAccount(paymentAccount);
    }

    @Override
    public void deleteBankAccountById(Long id) {
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
