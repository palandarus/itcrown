package ru.itcrown.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itcrown.models.Organization;
import ru.itcrown.services.OrganizationService;

import java.util.List;

@Controller
@RequestMapping("/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;
    private static final Logger getLogger=LoggerFactory.getLogger(OrganizationController.class);

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    private static final Logger logger = LoggerFactory.getLogger(OrganizationController.class);


    @GetMapping()
    public String showAllOrganization(Model model) {
        List<Organization> organizationList = organizationService.findAll();
        model.addAttribute("organizationList", organizationList);

        return "organizations";
    }

    @GetMapping("/organizations/edit/{id}")
    public String showOrganizationEditForm(@PathVariable Long id, Model model) {
        Organization organization = organizationService.findById(id);
        model.addAttribute("organization", organization);
        return "organization";
    }

    @GetMapping("/organizations/add")
    public String addOrganization(
            Model model
    ) {
        model.addAttribute("organization", new Organization());
        return "organization_create_form";
    }

    @PostMapping("/organizations/add")
    public String addRole(
            @ModelAttribute Organization organization,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "organizations_add_form";
        }
        organizationService.saveOrUpdate(organization);
        return "redirect:/organizations";
    }




    @PostMapping("/organizations/edit")
    public String showEditForm(@ModelAttribute Organization organization) {
        organizationService.saveOrUpdate(organization);
        return "redirect:/organizations";
    }

    @DeleteMapping("/organizations/remove/{id}")
    public String removeRole(
            @PathVariable("id") Long id,
            Model model
    ){
        organizationService.removeById(id);
        return "redirect:/organizations";
    }

}
