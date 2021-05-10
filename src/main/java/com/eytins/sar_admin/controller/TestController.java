package com.eytins.sar_admin.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 前端测试用controller
 * @Author Eytins
 * @Create 2021/5/10 23:59
 */

@Profile("front")
@Controller
public class TestController {

    @RequestMapping("/details")
    public String details(){
        return "/details";
    }

    @RequestMapping("/login")
    public String login(){
        return "/login";
    }

    @RequestMapping("/main")
    public String main(){
        return "/main";
    }

    @RequestMapping("/Map")
    public String map(){
        return "/Map";
    }

    @RequestMapping("/mission")
    public String mission(){
        return "/mission";
    }

    @RequestMapping("/test")
    public String test(){
        return "/test";
    }

    @RequestMapping("/Timeline")
    public String timeline(){
        return "/Timeline";
    }

    @RequestMapping("/User")
    public String user(){
        return "/User";
    }

}
