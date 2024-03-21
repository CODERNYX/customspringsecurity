package com.example.springsecurityolderversionsecond.controller;

import com.example.springsecurityolderversionsecond.model.User;
import com.example.springsecurityolderversionsecond.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository dao;

    @RequestMapping("/")
    public String home(Model m) {
        m.addAttribute("user", new User());
        return "home";
    }

    @RequestMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        String password=user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        dao.save(user);
        return "home";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/user")
    public String user(){
        return "user";
    }
}