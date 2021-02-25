package ru.itcrown.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itcrown.models.Bill;
import ru.itcrown.models.Organization;
import ru.itcrown.repositories.BillRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class BillServiceImpl implements BillService {

    private Map<Long, Bill> billMap = new HashMap<>();
    private final BillRepository billRepository;

    @Autowired
    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public List<Bill> findAll() {
        billMap.clear();
        billMap = billRepository.findAll();
        return billMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public List<Bill> getAllByOrganization(Organization organization) {
        return billRepository.findByOrganization(organization);
    }

    @Override
    public Bill getBillById(Long id) {
        if (billMap.get(id) != null) return billMap.get(id);
        else {
            findAll();
            return billMap.get(id);
        }
    }

    @Override
    public Bill getBillByNumber(String number) {
        return billRepository.findByNumber(number);
    }

    @Override
    public Bill getBillByDate(Date date) {

        return billRepository.findByDate(date);
    }

    @Override
    public void saveOrUpdateBill(Bill bill) {
        billRepository.save(bill);
        billMap.put(bill.getId(),bill);
    }

    @Override
    public void deleteBillById(Long id) {
        billRepository.removeById(id);
        billMap.remove(id);
        findAll();
    }
}
