package com.eytins.sar_admin;

import com.eytins.sar_admin.dao.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SarAdminApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println(userMapper.queryByUserName("admin"));
    }

}
