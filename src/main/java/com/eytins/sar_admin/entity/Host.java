package com.eytins.sar_admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Description
 * @Author Eytins
 * @Create 2021/5/12 13:57
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Host {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String ipAddress;
    private String username;
    private String password;
    private String description;
}
