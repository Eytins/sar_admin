package com.eytins.sar_admin.controller;

import com.eytins.sar_admin.entity.User;
import com.eytins.sar_admin.service.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author Eytins
 * @Create 2021/5/11 21:01
 */

@Profile({"dev", "default"})
@Controller
public class RegisterController {

    final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/register_main")
    public String registerMain() {
        return "register";
    }

    @RequestMapping("/register")
    public String register(User user,
                           Model model) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles("ROLE_" + user.getRoles());

        if (userService.addUser(user)) {
            return "login";
        } else {
            model.addAttribute("registerFail", "T");
            return "register";
        }
    }

}
