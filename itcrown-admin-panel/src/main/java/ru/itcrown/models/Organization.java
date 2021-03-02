package ru.itcrown.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@NoArgsConstructor
@Data
public class Organization extends AbstractModel{

    private String name;
    private String director;
    private String accountant;
    private String inn;
    private String ksk;
    private Collection<BankAccount> bankAccounts=new ArrayList<>();

    public void addBankAccount(BankAccount bankAccount){
        if(!bankAccounts.contains(bankAccount)) bankAccounts.add(bankAccount);
    }

    public void removeBankAccount(BankAccount bankAccount){
        if(!bankAccounts.contains(bankAccount)) bankAccounts.remove(bankAccount);
    }

    public Organization(Long id, String name, String director, String accountant, String inn, String ksk) {
        setId(id);
        this.name = name;
        this.director = director;
        this.accountant = accountant;
        this.inn = inn;
        this.ksk = ksk;
    }
}
