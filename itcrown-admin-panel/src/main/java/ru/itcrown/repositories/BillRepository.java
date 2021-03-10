package ru.itcrown.repositories;

import ru.itcrown.models.Bill;
import ru.itcrown.models.Organization;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BillRepository {

    Map<Long, Bill> findAll();
    Bill findById(Long id);
    void removeById(Long id);
    void save(Bill bill);

    List<Bill> findByOrganization(Organization organization);

    Bill findByNumber(String number);

    Bill findByDate(Date date);
}
