package com.eytins.sar_admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author Eytins
 * @Create 2021/5/12 13:57
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Host {
    private long id;
    private String ipAddress;
    private String username;
    private String password;
    private String description;
}
