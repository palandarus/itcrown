package ru.itcrown.services;

import java.util.Date;

public interface BankStatementAPI {
    boolean checkNewPayments();

    void downloadBankStatement(Date beginDateTime, Date endDateTime);

    void addListener(Listener listener);

    void removeListener(Listener listener);
}
