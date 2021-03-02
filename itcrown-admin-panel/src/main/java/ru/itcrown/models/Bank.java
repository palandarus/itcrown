package ru.itcrown.models;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Bank extends AbstractModel{

    private String name;
    private String correspondentAccount;
    private String bik;


    public Bank(Long id) {
        setId(id);
    }


}
