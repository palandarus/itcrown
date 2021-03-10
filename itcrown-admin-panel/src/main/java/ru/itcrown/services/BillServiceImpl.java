package ru.itcrown.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itcrown.models.Bill;
import ru.itcrown.repositories.BillRepository;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


@Service
public class BillServiceImpl implements BillService {

    private Map<Long, Bill> billMap = new ConcurrentHashMap<>();
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
    public Bill findById(Long id) {
        if (billMap.get(id) != null) return billMap.get(id);
        else {
            findAll();
            return billMap.get(id);
        }
    }

    @Override
    public Bill findByNumber(String number) {
        return billRepository.findByNumber(number);
    }

    @Override
    public Bill findByDate(Date date) {

        return billRepository.findByDate(date);
    }

    @Override
    public void saveOrUpdate(Bill bill) {
        billRepository.save(bill);
        billMap.put(bill.getId(), bill);
    }

    @Override
    public void removeById(Long id) {
        billRepository.removeById(id);
        billMap.remove(id);
        findAll();
    }
}
