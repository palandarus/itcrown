package ru.itcrown.services;

import ru.itcrown.models.Usluga;

import java.util.List;

public interface UslugaService {
    List<Usluga> findAll();
    Usluga findById(Long id);
    Usluga findByName(String name);
    void saveOrUpdate(Usluga usluga);
    void removeById(Long id);
}
