package ru.itcrown.repositories;

import org.springframework.stereotype.Component;
import ru.itcrown.models.Bill;
import ru.itcrown.models.Organization;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class BillRepositoryDaoImpl extends DefaultDaoRepository implements BillRepository {

    @Override
    public List<Bill> findByOrganization(Organization organization) {
        return null;
    }

    @Override
    public Bill findByNumber(String number) {
        return null;
    }

    @Override
    public Bill findByDate(Date date) {
        return null;
    }

    @Override
    public Map<Long, Bill> findAll() {
        String SQL = "select * from bill";
        return null;
    }

    @Override
    public Bill findById(Long id) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public void save(Bill bill) {

    }
}
