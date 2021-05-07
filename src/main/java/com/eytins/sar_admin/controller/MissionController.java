package com.eytins.sar_admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mission")
public class MissionController {

    /**
     * 跳任务管理主界面
     * @return
     */
    @RequestMapping("/main")
    public String mission(){
        return "mission";
    }

    /**
     * Map功能
     * @return
     */
    @RequestMapping("/Map")
    public String map(){
        return "Map";
    }

    /**
     * Details功能
     * @return
     */
    @RequestMapping("/details")
    public String details(){
        return "details";
    }

    /**
     * Timeline功能
     * @return
     */
    @RequestMapping("/Timeline")
    public String timeline(){
        return "Timeline";
    }

    /**
     * Start New Mission功能
     * @return
     */
    @RequestMapping("/addNew")
    public String addNew(){
        return "addNew";
    }
}
