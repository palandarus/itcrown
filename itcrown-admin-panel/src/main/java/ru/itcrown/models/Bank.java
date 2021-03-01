package ru.itcrown.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@Setter
@Getter
public class Bank extends AbstractModel{

    private String name;
    private String correspondentAccount;
    private String bik;


    public Bank(Long id) {
        setId(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) &&
                Objects.equals(correspondentAccount, bank.correspondentAccount) &&
                Objects.equals(bik, bank.bik);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, correspondentAccount, bik);
    }
}
