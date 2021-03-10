package ru.itcrown.services;

import ru.itcrown.models.Bill;

public interface DocumentTransportService {

    void sendBill(String address, Bill bill);
    String makeLetter(Bill bill);

}
