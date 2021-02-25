package ru.itcrown.services;

import ru.itcrown.models.Bill;
import ru.itcrown.models.Organization;

import java.util.Date;
import java.util.List;

public interface BillService {

    List<Bill> findAll();

    List<Bill> getAllByOrganization(Organization organization);


    Bill findByNumber(String number);

    Bill findByDate(Date date);


    void removeById(Long id);

    Organization findById(Long id);

    void saveOrUpdate(Bill bill);
}
