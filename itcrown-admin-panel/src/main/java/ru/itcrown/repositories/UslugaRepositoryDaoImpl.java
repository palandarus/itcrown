package ru.itcrown.repositories;

import org.springframework.stereotype.Component;
import ru.itcrown.models.Usluga;

import java.util.Map;

@Component
public class UslugaRepositoryDaoImpl extends DefaultDaoRepository implements UslugaRepository {

    @Override
    public Map<Long, Usluga> findAll() {
        return null;
    }

    @Override
    public Usluga findByName(String name) {
        return null;
    }

    @Override
    public void save(Usluga usluga) {

    }

    @Override
    public void removeById(Long id) {

    }
}
