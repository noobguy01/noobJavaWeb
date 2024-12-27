package org.noob.design.controller;


import org.noob.design.pojo.User;
import org.noob.design.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@SessionAttributes("user")
public class RegisterController {
    @Autowired
    private UserService userService;
    @RequestMapping("/register")
    public String register(Model model) {
        return "register";
    }
    @PostMapping("/register/register")
    public String register(Model model, @RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("repassword") String repassword, RedirectAttributes redirectAttributes) {

    if(repassword.equals(password)) {
        User byUsername = userService.findByUsername(username);
        if(byUsername != null) {
            redirectAttributes.addFlashAttribute("error","用户名重复") ;
            return "redirect:/register" ;

        }else{
            User user = new User() ;
            user.setUsername(username);
            user.setPassword(password);
            userService.register(user) ;
            user = userService.findByUsername(username);
            model.addAttribute("user",user);
            redirectAttributes.addFlashAttribute("success","注册成功") ;
        }
    }else {
        redirectAttributes.addFlashAttribute("error","两次密码不一样") ;
        return "redirect:/register" ;
    }
    return "redirect:/";

    }
}
