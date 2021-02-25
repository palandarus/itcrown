package ru.itcrown.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itcrown.models.BankAccount;
import ru.itcrown.models.Organization;
import ru.itcrown.repositories.OrganizationRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private Map<Long, Organization> organizationMap=new HashMap<>();

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository){
        this.organizationRepository=organizationRepository;
    }

    @Override
    public List<Organization> findAll() {
        organizationMap.clear();
        organizationMap = organizationRepository.findAll();
        return organizationMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Organization findById(Long id) {
        if (organizationMap.get(id) != null) return organizationMap.get(id);
        else {
            findAll();
            return organizationMap.get(id);
        }

    }

    @Override
    public Organization findByName(String name) {
        return organizationRepository.findByName(name);
    }

    @Override
    public void saveOrUpdate(Organization organization) {
        organizationRepository.save(organization);
        organizationMap.put(organization.getId(),organization);
    }

    @Override
    public void removeById(Long id) {
        organizationMap.remove(id);
        organizationRepository.removeById(id);
    }

    @Override
    public void addBankAccount(Long orgId, BankAccount bankAccount) {
        organizationMap.get(orgId).addBankAccount(bankAccount);
        organizationRepository.save(organizationMap.get(orgId));
    }

    @Override
    public void deleteBankAccount(Long orgId, BankAccount bankAccount) {
        organizationMap.get(orgId).removeBankAccount(bankAccount);
        organizationRepository.save(organizationMap.get(orgId));
    }
}
