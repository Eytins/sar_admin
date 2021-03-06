package com.eytins.sar_admin.controller;

import com.eytins.sar_admin.entity.User;
import com.eytins.sar_admin.service.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Description 前端测试用controller
 * @Author Eytins
 * @Create 2021/5/10 23:59
 */

@Profile("front")
@Controller
public class TestController {

    final UserService userService;
    public TestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/mission/details")
    public String details() {
        return "details";
    }

    @RequestMapping("/login")
    public String login() {
        return "main";
    }

    @RequestMapping("/register_main")
    public String registerMain(){
        return "register";
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @RequestMapping("/mission/Map")
    public String map() {
        return "Map";
    }

    @RequestMapping("/mission/main")
    public String mission() {
        return "mission";
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/mission/Timeline")
    public String timeline() {
        return "Timeline";
    }

    @RequestMapping("/user/main")
    public String user() {
        return "User";
    }

    @RequestMapping("/log/main")
    public String log() {
        return "log";
    }

    @RequestMapping("/computer/main")
    public String computer() {
        return "computer";
    }

    @PostMapping("/queryUser")
    public List<User> queryUser(){
        return userService.queryUser();
    }

}
