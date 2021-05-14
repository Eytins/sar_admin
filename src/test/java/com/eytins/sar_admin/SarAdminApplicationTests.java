package com.eytins.sar_admin;

import com.eytins.sar_admin.dao.LogMapper;
import com.eytins.sar_admin.dao.UserMapper;
import com.eytins.sar_admin.entity.Host;
import com.eytins.sar_admin.entity.Log;
import com.eytins.sar_admin.framework.ssh.Shell;
import com.eytins.sar_admin.service.HostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class SarAdminApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    HostService hostService;

    @Autowired
    LogMapper logMapper;

    @Test
    void contextLoads() {
        Host host = new Host(0, "112.124.54.71", "root", "292918726Lmz", "");
        Shell shell = new Shell(host.getUsername(), host.getPassword(), host.getIpAddress());
        int exitCode = shell.exec("ls");

        Log log = new Log();
        log.setIpAddress(host.getIpAddress());
        log.setCommand("ls");
        log.setMessage(shell.getLog().toString());
        log.setDescription("测试主机能否正常连接");
        log.setTime(new Date(System.currentTimeMillis()));
        logMapper.insert(log);

    }

}
