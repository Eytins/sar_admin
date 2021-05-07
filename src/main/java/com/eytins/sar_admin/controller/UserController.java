package com.eytins.sar_admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    //用户管理主界面
    @RequestMapping("/main")
    public String Usermain(){
        return "User";
    }
}
