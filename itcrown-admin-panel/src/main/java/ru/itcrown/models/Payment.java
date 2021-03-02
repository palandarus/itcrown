package ru.itcrown.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class Payment extends AbstractModel{
    private Date dateTime;
    private String number;
    private String inn;
    private String clientName;
    private String comment;
    private BankStatement bankStatement;

    public Payment(Long id, Date dateTime, String number, String inn, String clientName, String comment, BankStatement bankStatement) {
        setId(id);
        this.dateTime = dateTime;
        this.number = number;
        this.inn = inn;
        this.clientName = clientName;
        this.comment = comment;
        this.bankStatement = bankStatement;
    }
}
