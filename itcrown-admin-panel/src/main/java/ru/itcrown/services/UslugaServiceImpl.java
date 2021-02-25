package ru.itcrown.services;

import org.springframework.stereotype.Service;
import ru.itcrown.models.Usluga;

import java.util.List;

@Service
public class UslugaServiceImpl implements UslugaService {

    @Override
    public List<Usluga> findAll() {
        return null;
    }

    @Override
    public Usluga findById(Long id) {
        return null;
    }

    @Override
    public Usluga findByName(String name) {
        return null;
    }

    @Override
    public void saveOrUpdate(Usluga usluga) {

    }

    @Override
    public void removeById(Long id) {

    }
}
