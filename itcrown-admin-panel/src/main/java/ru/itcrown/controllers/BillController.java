package ru.itcrown.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itcrown.models.Bill;
import ru.itcrown.services.BillService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/bills")
@Slf4j
public class BillController {

    private final BillService billService;


    @GetMapping()
    public String showAllBills(Model model) {
        List<Bill> billList = billService.findAll();
        model.addAttribute("billList", billList);

        return "bills";
    }

    @GetMapping("/bills/edit/{id}")
    public String showBillEditForm(@PathVariable Long id, Model model) {
        Bill bill = billService.findById(id);
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
