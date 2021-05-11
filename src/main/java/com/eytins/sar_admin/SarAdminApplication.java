package com.eytins.sar_admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author eytins
 */

@SpringBootApplication
@MapperScan("com.eytins.sar_admin.dao")
@org.mybatis.spring.annotation.MapperScan(basePackages = "com.eytins.sar_admin.dao")
public class SarAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SarAdminApplication.class, args);
    }

}
