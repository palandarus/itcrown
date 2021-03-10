package ru.itcrown.services;

import ru.itcrown.models.Bill;

import java.util.Date;
import java.util.List;

public interface BillService {

    List<Bill> findAll();



    Bill findByNumber(String number);

    Bill findByDate(Date date);


    void removeById(Long id);

    Bill findById(Long id);

    void saveOrUpdate(Bill bill);
}
