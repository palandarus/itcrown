package ru.itcrown.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Bank extends AbstractModel{

    private String name;
    private String correspondentAccount;
    private String bik;

}