package ru.itcrown.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itcrown.models.Bill;
import ru.itcrown.models.DocumentTransport;

@Service
public class DocumentTransportServiceEmailImpl implements DocumentTransportService {

    private final DocumentTransport documentTransport;

    @Autowired
    public DocumentTransportServiceEmailImpl(DocumentTransport documentTransport) {
        this.documentTransport = documentTransport;
    }

    @Override
    public void sendBill(String address, Bill bill) {
        String mail=makeLetter(bill);
        System.out.println(documentTransport.getLogin()+documentTransport.getPassword()+mail);
    }

    @Override
    public String makeLetter(Bill bill) {
        return null;
    }
}
