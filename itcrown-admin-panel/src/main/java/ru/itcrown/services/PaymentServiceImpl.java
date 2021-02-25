package ru.itcrown.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itcrown.models.BankStatement;
import ru.itcrown.models.Bill;
import ru.itcrown.models.Payment;
import ru.itcrown.repositories.PaymentRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {


    private final PaymentRepository paymentRepository;
    private Map<Long, Payment> paymentMap = new HashMap<>();

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> findAll() {
        paymentMap.clear();
        paymentMap = paymentRepository.findAll();
        return paymentMap.values().stream().collect(Collectors.toList());
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
