package com.eytins.sar_admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    /**
     * 登录失败后跳转到login.html并告诉页面失败了
     * @param model
     * @return
     */
    @RequestMapping("/failure")
    public String failure(Model model){
        model.addAttribute("loginFail","T");
        return "login";
    }

    @RequestMapping("/toMain")
    public String toMain(){
        return "main";
    }
}
