package ru.itcrown.controllers;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itcrown.models.BankAccount;
import ru.itcrown.services.BankAccountService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/bankaccounts")
public class BankAccountController {

    private static final Logger getLogger = LoggerFactory.getLogger(BankAccountController.class);
    private final BankAccountService bankAccountService;


    @GetMapping()
    public String showAllBankAccounts(Model model) {
        List<BankAccount> bankAccountList = bankAccountService.findAll();
        model.addAttribute("bankAccountList", bankAccountList);

        return "bankaccounts";
    }

    @GetMapping("/bankaccounts/edit/{id}")
    public String showBankAccountEditForm(@PathVariable Long id, Model model) {
        BankAccount bankAccount = bankAccountService.findById(id);
        model.addAttribute("bankAccount", bankAccount);
        return "bankaccount";
    }

    @GetMapping("/bankaccounts/add")
    public String addBankAccount(
            Model model
    ) {
        model.addAttribute("bankAccount", new BankAccount());
        return "bankaccount_create_form";
    }

    @PostMapping("/bankaccounts/add")
    public String addBankAccount(
            @ModelAttribute BankAccount bankAccount,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "bankaccount_add_form";
        }
        bankAccountService.saveOrUpdate(bankAccount);
        return "redirect:/bankaccounts";
    }


    @PostMapping("/bankaccounts/edit")
    public String showEditForm(@ModelAttribute BankAccount bankAccount) {
        bankAccountService.saveOrUpdate(bankAccount);
        return "redirect:/bankaccounts";
    }

    @DeleteMapping("/bankaccounts/remove/{id}")
    public String removeBankAccount(
            @PathVariable("id") Long id,
            Model model
    ) {
        bankAccountService.removeById(id);
        return "redirect:/bankaccounts";
    }

}
