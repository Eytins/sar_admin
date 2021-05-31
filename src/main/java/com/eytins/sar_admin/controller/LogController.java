package com.eytins.sar_admin.controller;

import com.eytins.sar_admin.entity.Log;
import com.eytins.sar_admin.service.LogService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @Description
 * @Author Eytins
 * @Create 2021/5/31 21:23
 */

@Profile({"dev","default"})
@Controller("/log")
public class LogController {

    final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping("/queryLog")
    public List<Log> queryLog(){
        return logService.queryLog();
    }
}
