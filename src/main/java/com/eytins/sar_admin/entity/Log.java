package com.eytins.sar_admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Description
 * @Author Eytins
 * @Create 2021/5/14 17:58
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String ipAddress;
    private String command;
    private String message;
    private String description;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;
}
