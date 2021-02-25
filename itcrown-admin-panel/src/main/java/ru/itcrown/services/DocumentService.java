package ru.itcrown.services;

import ru.itcrown.models.Bill;
import ru.itcrown.models.Document;

import java.util.Date;
import java.util.List;

public interface DocumentService {

    List<Document> findAll();

    Document findById(Long id);

    Document findByNumber(String number);


    Document findByDate(Date date);

    void saveOrUpdate(Document document);

    Document createDocument(String docType, Bill bill, Date docDate);

    void removeById(Long id);



}
