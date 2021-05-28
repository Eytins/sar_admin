package com.eytins.sar_admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mission {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String mname;
    private long by;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;
}
