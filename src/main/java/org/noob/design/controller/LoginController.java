package org.noob.design.controller;

import jakarta.servlet.http.HttpSession;
import org.noob.design.pojo.User;
import org.noob.design.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("user")
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String login(Model model,RedirectAttributes redirAttrs) {

        return "login";
    }
    @PostMapping("/login/login")
    public String login(Model model, RedirectAttributes redirAttrs, String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User login = userService.login(user);
        if(login != null) {
            model.addAttribute("user", login);
            redirAttrs.addFlashAttribute("success", "登录成功");

        }else {
            redirAttrs.addFlashAttribute("error", "账户密码不匹配");

            return "redirect:/login";
        }
        return "redirect:/" ;
    }
    @GetMapping("/logout")
    public String logout(Model model, RedirectAttributes redirAttrs, SessionStatus sessionStatus) {

       sessionStatus.setComplete();
       redirAttrs.addFlashAttribute("success","退出成功") ;
       return "redirect:/";
    }
}
