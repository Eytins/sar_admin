package com.eytins.sar_admin.controller;

import com.eytins.sar_admin.entity.Host;
import com.eytins.sar_admin.service.HostService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @Description
 * @Author Eytins
 * @Create 2021/5/12 13:54
 */

@Profile({"dev", "default"})
@Controller("/host")
public class HostController {

    final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @PostMapping("/queryHost")
    public List<Host> queryHost() {
        return hostService.queryHost();
    }

    @PostMapping("/addHost")
    public String addHost(Host host, Model model) {
        if (!hostService.addHost(host)) {
            //todo:异常处理(如果重复了，前端弹窗)
        }

        return "";
    }

    @DeleteMapping("/deleteHost")
    public String deleteHost() {
        return "";
    }

    @PostMapping("/uploadImage")
    public void uploadImage() {

    }

    @GetMapping("/deployService")
    public void deployService() {

    }
}
