package com.eytins.sar_admin.service;

import com.eytins.sar_admin.entity.Host;

/**
 * @Description
 * @Author Eytins
 * @Create 2021/5/12 13:59
 */

public interface HostService {
    /**
     * 向表中添加新主机
     * @return
     */
    boolean addHost(Host host);
}
