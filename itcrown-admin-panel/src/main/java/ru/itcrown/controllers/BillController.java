package ru.itcrown.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itcrown.models.Bill;
import ru.itcrown.models.Organization;
import ru.itcrown.services.BillService;

import java.util.List;

@Controller
@RequestMapping("/bills")
public class BillController {

    private static final Logger getLogger = LoggerFactory.getLogger(BillController.class);
    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }


    @GetMapping()
    public String showAllBills(Model model) {
        List<Bill> billList = billService.findAll();
        model.addAttribute("billList", billList);

        return "bills";
    }

    @GetMapping("/bills/edit/{id}")
    public String showBillEditForm(@PathVariable Long id, Model model) {
        Organization bill = billService.findById(id);
        model.addAttribute("bill", bill);
        return "bill";
    }

    @GetMapping("/bills/add")
    public String addBill(
            Model model
    ) {
        model.addAttribute("bill", new Bill());
        return "bill_create_form";
    }

    @PostMapping("/bills/add")
    public String addBill(
            @ModelAttribute Bill bill,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "bills_add_form";
        }
        billService.saveOrUpdate(bill);
        return "redirect:/bills";
    }


    @PostMapping("/bills/edit")
    public String showEditForm(@ModelAttribute Bill bill) {
        billService.saveOrUpdate(bill);
        return "redirect:/bills";
    }

    @DeleteMapping("/bills/remove/{id}")
    public String removeBill(
            @PathVariable("id") Long id,
            Model model
    ) {
        billService.removeById(id);
        return "redirect:/bills";
    }

}
