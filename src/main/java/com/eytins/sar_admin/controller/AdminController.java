package com.eytins.sar_admin.controller;

import com.eytins.sar_admin.entity.Host;
import com.eytins.sar_admin.service.HostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Description
 * @Author Eytins
 * @Create 2021/5/12 13:54
 */

@Controller("/admin")
public class AdminController {

    final HostService hostService;

    public AdminController(HostService hostService) {
        this.hostService = hostService;
    }

    @PostMapping("/addHost")
    public String addHost(Host host, Model model) {
        if (!hostService.addHost(host)) {
            //todo:异常处理
        }

        return "";
    }

}
