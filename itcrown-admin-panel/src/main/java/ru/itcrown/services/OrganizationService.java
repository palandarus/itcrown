package ru.itcrown.services;

import ru.itcrown.models.BankAccount;
import ru.itcrown.models.Organization;

import java.util.List;

public interface OrganizationService {

    List<Organization> findAll();

    Organization findById(Long id);

    Organization findByName(String name);

    void saveOrUpdate(Organization organization);

    void removeById(Long id);

    void addBankAccount(Long orgId, BankAccount bankAccount);

    void deleteBankAccount(Long orgId, BankAccount bankAccount);

}
