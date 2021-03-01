package ru.itcrown.controllers;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itcrown.models.Role;
import ru.itcrown.services.RoleService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;
    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);


    @GetMapping()
    public String showAllRoles(Model model) {
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles", roles);

        return "roles";
    }

    @GetMapping("/roles/edit/{id}")
    public String showRoleEditForm(@PathVariable Long id, Model model) {
        Role role = roleService.getRoleById(id);
        model.addAttribute("role", role);
        return "role";
    }

    @GetMapping("/roles/add")
    public String addRole(
            Model model
    ) {
        model.addAttribute("role", new Role());
        return "role_create_form";
    }

    @PostMapping("/roles/add")
    public String addRole(
            @ModelAttribute Role role,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "role_add_form";
        }
        roleService.saveOrUpdate(role);
        return "redirect:/roles";
    }


    @PostMapping("/roles/edit")
    public String showEditForm(@ModelAttribute Role role) {
        roleService.saveOrUpdate(role);
        return "redirect:/roles";
    }

    @DeleteMapping("/roles/remove/{id}")
    public String removeRole(
            @PathVariable("id") Long id,
            Model model
    ){
        roleService.deleteRoleById(id);
        return "redirect:/roles";
    }

}
