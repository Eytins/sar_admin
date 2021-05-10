package com.eytins.sar_admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author Eytins
 * @Create 2021/5/7 23:43
 */

@Controller
public class LoginController {

    @RequestMapping("/register_main")
    public String register(){
        return "register";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }
}
