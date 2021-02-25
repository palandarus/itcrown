package ru.itcrown.services;

import org.springframework.stereotype.Service;
import ru.itcrown.models.BankStatement;
import ru.itcrown.models.Bill;
import ru.itcrown.models.Payment;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public List<Payment> findAll() {
        return null;
    }

    @Override
    public List<Payment> getAllByDate(Date date) {
        return null;
    }

    @Override
    public Bill getPaymentById(Long id) {
        return null;
    }

    @Override
    public Bill getPaymentByNumber(String number) {
        return null;
    }

    @Override
    public void saveOrUpdatePayment(Payment payment) {

    }

    @Override
    public void deletePaymentById(Long id) {

    }

    @Override
    public Collection<Payment> getByBankStatement(BankStatement bankStatement) {
        return null;
    }
}
