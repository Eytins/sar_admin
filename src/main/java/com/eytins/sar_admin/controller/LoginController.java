package com.eytins.sar_admin.controller;

import org.springframework.stereotype.Controller;

/**
 * @Description
 * @Author Eytins
 * @Create 2021/5/7 23:43
 */

@Controller
public class LoginController {


    //进�?�注�?
    @RequestMapping("/register_main")
//    public String register(@RequestParam("username")String username,
//                           @RequestParam("pwd")String pwd,
//                           @RequestParam("pwd2")String pwd2){
//        //对用户名，密码进行�?�理判断
//
//        return "login";
//    }
    public String register(){
        return "register";
    }

    *//**
     * 进系�?
     *
     * @param username
     * @param password
     * @param model
     * @return
     *//*
    @RequestMapping("/main")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
            if ("admin".equals(username) && "123456".equals(password)) {
                model.addAttribute("username", username);
                return "main";
            } else {
                return "login";
            }
        } else {
            return "login";
        }
    }

}
