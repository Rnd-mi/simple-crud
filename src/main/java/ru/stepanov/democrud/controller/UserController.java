package ru.stepanov.democrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.stepanov.democrud.model.User;
import ru.stepanov.democrud.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String findAll(Model model) {
        List<User> users = new ArrayList<>(userService.findAll());
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/create")
    public String createUserForm() {
        return "user-create";
    }

    @PostMapping
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }






}
