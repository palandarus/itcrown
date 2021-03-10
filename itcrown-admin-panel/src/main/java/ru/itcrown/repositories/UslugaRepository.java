package ru.itcrown.repositories;

import ru.itcrown.models.Usluga;

import java.util.Map;

public interface UslugaRepository {
    Map<Long, Usluga> findAll();

    Usluga findByName(String name);

    void save(Usluga usluga);

    void removeById(Long id);
}
