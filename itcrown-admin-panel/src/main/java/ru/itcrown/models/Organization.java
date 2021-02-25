package ru.itcrown.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
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
