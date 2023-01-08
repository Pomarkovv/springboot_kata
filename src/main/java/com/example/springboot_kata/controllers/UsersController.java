package com.example.springboot_kata.controllers;


import com.example.springboot_kata.models.User;
import com.example.springboot_kata.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String printUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/addUser")
    public String newPerson(@ModelAttribute("user") User user) {
        return "addUser";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/show")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("edited_user", userService.findOne(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("edited_user") User user,
                             @PathVariable("id") int id) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}/show")
    public String delete(@PathVariable("id") int id){
        userService.removeUser(id);
        return "redirect:/users";
    }
}

