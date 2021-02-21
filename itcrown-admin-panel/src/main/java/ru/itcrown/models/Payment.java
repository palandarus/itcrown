package ru.itcrown.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Payment extends AbstractModel{
    private Date dateTime;
    private String number;
    private String inn;
    private String clientName;
    private String comment;
}
