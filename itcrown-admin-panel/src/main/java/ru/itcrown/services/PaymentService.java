package ru.itcrown.services;

import ru.itcrown.models.BankStatement;
import ru.itcrown.models.Bill;
import ru.itcrown.models.Payment;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface PaymentService {

    List<Payment> findAll();

    List<Payment> getAllByDate(Date date);

    Bill getPaymentById(Long id);

    Bill getPaymentByNumber(String number);


    void saveOrUpdatePayment(Payment payment);

    void deletePaymentById(Long id);


    Collection<Payment> getByBankStatement(BankStatement bankStatement);
}
