package org.noob.design.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.noob.design.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@SessionAttributes("user")
public class IndexController {
    @RequestMapping("/")
    public String index(Model model) {

        return "index";
    }

}
