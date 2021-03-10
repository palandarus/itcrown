package ru.itcrown.repositories;

import ru.itcrown.models.Document;

import java.util.Date;
import java.util.Map;

public interface DocumentRepository {
    Map<Long, Document> findAll();

    Document findByNumber(String number);

    Document findByDate(Date date);

    void save(Document document);

    void removeById(Long id);
}
