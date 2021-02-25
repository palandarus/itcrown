package ru.itcrown.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itcrown.models.Bill;
import ru.itcrown.models.Document;
import ru.itcrown.repositories.DocumentRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class DocumentServicePdfImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    private Map<Long, Document> documentMap=new HashMap<>();

    @Autowired
    public DocumentServicePdfImpl(DocumentRepository documentRepository){
        this.documentRepository=documentRepository;
    }

    @Override
    public List<Document> findAll() {
        documentMap.clear();
        documentMap = documentRepository.findAll();
        return documentMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Document findById(Long id) {
        if (documentMap.get(id) != null) return documentMap.get(id);
        else {
            findAll();
            return documentMap.get(id);
        }


    }

    @Override
    public Document findByNumber(String number) {
        return documentRepository.findByNumber(number);
    }

    @Override
    public Document findByDate(Date date) {

        return documentRepository.findByDate(date);
    }

    @Override
    public void saveOrUpdate(Document document) {
        documentRepository.save(document);
        documentMap.put(document.getId(),document);
    }

    @Override
    public void removeById(Long id) {
        documentRepository.removeById(id);
        documentMap.remove(id);
    }

    @Override
    public Document createDocument(String docType, Bill bill, Date docDate) {
        System.out.println("pdf File was created");
        return null;
    }
}
