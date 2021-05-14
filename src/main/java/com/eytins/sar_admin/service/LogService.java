package com.eytins.sar_admin.service;

import com.eytins.sar_admin.entity.Log;

import java.util.List;

/**
 * @Description
 * @Author Eytins
 * @Create 2021/5/14 18:25
 */

public interface LogService {

    /**
     * 查询所有日志
     * @return
     */
    List<Log> queryHost();
}
