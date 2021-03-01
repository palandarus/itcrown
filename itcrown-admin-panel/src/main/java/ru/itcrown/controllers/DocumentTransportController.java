package ru.itcrown.controllers;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itcrown.models.Bill;
import ru.itcrown.services.DocumentTransportService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/documents/transport")
public class DocumentTransportController {
    private static final Logger logger= LoggerFactory.getLogger(DocumentTransportController.class);


    private final DocumentTransportService documentTransportService;


    @PostMapping("/documents/transport")
    public String transportDocument(@ModelAttribute Bill bill,
                                    @ModelAttribute String email) {
        documentTransportService.sendBill(email,bill);
        return "redirect:/documents";
    }

}
