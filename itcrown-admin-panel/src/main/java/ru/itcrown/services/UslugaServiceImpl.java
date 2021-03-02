package ru.itcrown.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itcrown.models.Usluga;
import ru.itcrown.repositories.UslugaRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class UslugaServiceImpl implements UslugaService {

    private final UslugaRepository uslugaRepository;
    private Map<Long, Usluga> uslugaMap = new ConcurrentHashMap<>();

    @Autowired
    public UslugaServiceImpl(UslugaRepository uslugaRepository) {
        this.uslugaRepository = uslugaRepository;
    }

    @Override
    public List<Usluga> findAll() {

        uslugaMap.clear();
        uslugaMap = uslugaRepository.findAll();
        return uslugaMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Usluga findById(Long id) {
        if (uslugaMap.get(id) != null) return uslugaMap.get(id);
        else {
            findAll();
            return uslugaMap.get(id);
        }
    }

    @Override
    public Usluga findByName(String name) {
        return uslugaRepository.findByName(name);
    }

    @Override
    public void saveOrUpdate(Usluga usluga) {
        uslugaRepository.save(usluga);
        uslugaMap.put(usluga.getId(), usluga);
    }

    @Override
    public void removeById(Long id) {
        uslugaRepository.removeById(id);
        uslugaMap.remove(id);
    }
}
