package ru.itcrown.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
public class BankStatement extends AbstractModel{

    private Date dateTime;
    private Collection<Payment> paymentsList=new ArrayList<>();

    public void addPayment(Payment payment){
        if(!paymentsList.contains(payment)) paymentsList.add(payment);
    }

    public void removePayment(Payment payment){
        if(!paymentsList.contains(payment)) paymentsList.remove(payment);
    }

}
