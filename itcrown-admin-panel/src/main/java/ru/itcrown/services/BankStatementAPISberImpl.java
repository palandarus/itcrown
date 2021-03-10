package ru.itcrown.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BankStatementAPISberImpl implements BankStatementAPI {

    private final List<Listener> listenersList = new ArrayList<>();

    @Override
    public boolean checkNewPayments() {
        return false;
    }

    @Override
    public void downloadBankStatement(Date beginDateTime, Date endDateTime) {

    }

    @Override
    public void addListener(Listener listener) {

    }

    @Override
    public void removeListener(Listener listener) {

    }

    void notify(String msg) {
        for (Listener listener : listenersList) {
            listener.notify(msg);
        }
    }


}
