package com.eytins.sar_admin.service.impl;

import com.eytins.sar_admin.dao.LogMapper;
import com.eytins.sar_admin.entity.Log;
import com.eytins.sar_admin.service.LogService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author Eytins
 * @Create 2021/5/14 18:26
 */

@Service
public class LogServiceImpl implements LogService {

    final LogMapper logMapper;

    public LogServiceImpl(LogMapper logMapper) {
        this.logMapper = logMapper;
    }

    @Override
    public List<Log> queryHost() {
        return logMapper.selectAll();
    }
}
