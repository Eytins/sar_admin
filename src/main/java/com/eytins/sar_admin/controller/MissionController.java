package com.eytins.sar_admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mission")
public class MissionController {

    //跳任务管理主界面
    @RequestMapping("/main")
    public String mission(){
        return "mission";
    }

    //Map功能
    @RequestMapping("/Map")
    public String Map(){
        return "Map";
    }

    //Details功能
    @RequestMapping("/details")
    public String details(){
        return "details";
    }

    //Timeline功能
    @RequestMapping("/Timeline")
    public String Timeline(){
        return "Timeline";
    }

    //Start New Mission功能
    @RequestMapping("/addNew")
    public String addNew(){
        return "addNew";
    }
}
