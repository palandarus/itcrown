package ru.itcrown.services;

import ru.itcrown.models.Bill;
import ru.itcrown.models.Organization;

import java.util.Date;
import java.util.List;

public interface BillService {

    List<Bill> findAll();

    List<Bill> getAllByOrganization(Organization organization);

    Bill getBillById(Long id);

    Bill getBillByNumber(String number);

    Bill getBillByDate(Date date);

    void saveOrUpdateBill(Bill bill);

    void deleteBillById(Long id);

}
