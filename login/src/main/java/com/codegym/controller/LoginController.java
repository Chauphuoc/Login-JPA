package com.codegym.controller;

import com.codegym.Login;
import com.codegym.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    UserService userService = new UserService();

    @GetMapping(value = "/login")
    public ModelAndView showFormLogin() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("login", new Login());
        modelAndView.addObject("message");
        return modelAndView;
    }

    @PostMapping(value = "/success")
    public ModelAndView processLogin(@ModelAttribute Login login) {
        ModelAndView modelAndView = new ModelAndView("success");
        if (userService.checkLogin(login)) {
            modelAndView.addObject("message", "Success");
        } else modelAndView.addObject("message", "fail");
        return modelAndView;
    }
}
