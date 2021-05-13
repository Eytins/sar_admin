package com.eytins.sar_admin;

import com.eytins.sar_admin.dao.UserMapper;
import com.eytins.sar_admin.entity.Host;
import com.eytins.sar_admin.service.HostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SarAdminApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    HostService hostService;

    @Test
    void contextLoads() {
        Host host = new Host(0, "112.124.54.71", "root", "292918726Lmz", "");
        System.out.println(hostService.testHost(host));
    }

}
