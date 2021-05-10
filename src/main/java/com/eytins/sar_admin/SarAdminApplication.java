package com.eytins.sar_admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author eytins
 */

@SpringBootApplication
@MapperScan("com.eytins.sar_admin.dao")
public class SarAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SarAdminApplication.class, args);
    }

}
