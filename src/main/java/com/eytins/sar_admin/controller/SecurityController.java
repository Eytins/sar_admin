package com.eytins.sar_admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author Eytins
 * @Create 2021/5/10 0:17
 */

@Controller
public class SecurityController {
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
}
