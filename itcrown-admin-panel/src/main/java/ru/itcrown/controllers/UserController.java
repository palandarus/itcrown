package ru.itcrown.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itcrown.models.User;
import ru.itcrown.services.UserService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserService userService;


    @GetMapping()
    public String showAllUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);

        return "users";
    }

    @GetMapping("/users/edit/{id}")
    public String showUserEditForm(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/users/add")
    public String addUser(
            Model model
    ) {
        model.addAttribute("user", new User());
        return "user_create_form";
    }

    @PostMapping("/users/add")
    public String addUser(
            @ModelAttribute User user,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "user_add_form";
        }
        userService.saveOrUpdate(user);
        return "redirect:/users";
    }

    @PostMapping("/users/edit")
    public String showEditForm(@ModelAttribute User user) {
        userService.saveOrUpdate(user);
        return "redirect:/users";
    }

    @DeleteMapping("/users/remove/{id}")
    public String removeUser(
            @PathVariable("id") Long id,
            Model model
    ){
        userService.removeById(id);
        return "redirect:/users";
    }

}
