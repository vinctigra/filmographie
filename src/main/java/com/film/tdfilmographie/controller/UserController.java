package com.film.tdfilmographie.controller;

import com.film.tdfilmographie.bo.User;
import com.film.tdfilmographie.service.Impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserImpl userService;

    @GetMapping("/register")
    public String getRegisterUser(Model model){
        model.addAttribute("user", new User());
        return "/user/register.html";
    }

    @GetMapping("/login")
    public String getLoginUser(Model model){
        return "/user/login.html";
    }

    @PostMapping("/connection")
    public String connection(RedirectAttributes redirect){
        redirect.addFlashAttribute("message", "connection réussi");
        return "redirect:/";
    }

    @PostMapping("/add-register")
    public String register(User user, Model model, RedirectAttributes redirect){
        userService.addUser(user);
        model.addAttribute("user", userService.getById());
        return "redirect:/";
    }
}
