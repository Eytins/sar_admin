package com.eytins.sar_admin.service;

import com.eytins.sar_admin.entity.Host;

import java.util.List;

/**
 * @Description
 * @Author Eytins
 * @Create 2021/5/12 13:59
 */

public interface HostService {
    /**
     * 向表中添加新主机
     * @param host
     * @return
     */
    boolean addHost(Host host);

    /**
     * 搜索全部主机
     * @return
     */
    List<Host> queryHost();

    /**
     * 根据id删除主机
     * @param id
     */
    void deleteHost(Long id);
}
