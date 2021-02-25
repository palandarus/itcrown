package ru.itcrown.services;

import ru.itcrown.models.BankStatement;

import java.io.File;

public interface BankStatementAdapterService {
    void loadStatementFromFile(File file);

    BankStatement parseStatement(File file);
}
