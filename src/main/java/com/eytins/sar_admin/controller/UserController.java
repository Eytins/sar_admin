package com.eytins.sar_admin.controller;

import com.eytins.sar_admin.entity.User;
import com.eytins.sar_admin.service.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @Description
 * @Author Eytins
 * @Create 2021/5/31 20:59
 */

@Profile({"dev","default"})
@Controller("/user")
public class UserController {

    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/queryUser")
    public List<User> queryUser(){

        return null;
    }

    @PostMapping("/updateUser")
    public void updateUser(){

    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(){

    }

}
