package ru.itcrown.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itcrown.models.Usluga;
import ru.itcrown.services.UslugaService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/uslugi")
@Slf4j
public class UslugaController {

    private final UslugaService uslugiService;


    @GetMapping()
    public String showAllUslugi(Model model) {
        List<Usluga> uslugi = uslugiService.findAll();
        model.addAttribute("uslugi", uslugi);

        return "uslugi";
    }

    @GetMapping("/uslugi/edit/{id}")
    public String showUslugaEditForm(@PathVariable Long id, Model model) {
        Usluga usluga = uslugiService.findById(id);
        model.addAttribute("usluga", usluga);
        return "usluga";
    }

    @GetMapping("/uslugi/add")
    public String addUsluga(
            Model model
    ) {
        model.addAttribute("usluga", new Usluga());
        return "usluga_create_form";
    }

    @PostMapping("/uslugi/add")
    public String addRole(
            @ModelAttribute Usluga usluga,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "usluga_add_form";
        }
        uslugiService.saveOrUpdate(usluga);
        return "redirect:/uslugi";
    }


    @PostMapping("/uslugi/edit")
    public String showEditForm(@ModelAttribute Usluga usluga) {
        uslugiService.saveOrUpdate(usluga);
        return "redirect:/uslugi";
    }

    @DeleteMapping("/uslugi/remove/{id}")
    public String removeRole(
            @PathVariable("id") Long id,
            Model model
    ){
        uslugiService.removeById(id);
        return "redirect:/uslugi";
    }

}
