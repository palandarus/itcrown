package ru.itcrown.repositories;

import org.springframework.stereotype.Component;
import ru.itcrown.models.Document;

import java.util.Date;
import java.util.Map;

@Component
public class DocumentRepositoryDaoImpl extends DefaultDaoRepository implements DocumentRepository {

    @Override
    public Map<Long, Document> findAll() {
        return null;
    }

    @Override
    public Document findByNumber(String number) {
        return null;
    }

    @Override
    public Document findByDate(Date date) {
        return null;
    }

    @Override
    public void save(Document document) {

    }

    @Override
    public void removeById(Long id) {

    }
}
