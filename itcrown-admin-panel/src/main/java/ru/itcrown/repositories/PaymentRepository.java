package ru.itcrown.repositories;

import ru.itcrown.models.Payment;

import java.util.Map;

public interface PaymentRepository {
    Map<Long, Payment> findAll();
}
