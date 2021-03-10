package ru.itcrown.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itcrown.models.Bill;
import ru.itcrown.services.DocumentTransportService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/documents/transport")
@Slf4j
public class DocumentTransportController {


    private final DocumentTransportService documentTransportService;


    @PostMapping("/documents/transport")
    public String transportDocument(@ModelAttribute Bill bill,
                                    @ModelAttribute String email) {
        documentTransportService.sendBill(email,bill);
        return "redirect:/documents";
    }

}
