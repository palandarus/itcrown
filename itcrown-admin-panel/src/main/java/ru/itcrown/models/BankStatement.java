package ru.itcrown.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@NoArgsConstructor
@Data
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
