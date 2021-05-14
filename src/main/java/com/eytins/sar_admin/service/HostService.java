package com.eytins.sar_admin.service;

import com.eytins.sar_admin.entity.Host;
import com.eytins.sar_admin.framework.ssh.Shell;

import java.util.List;

/**
 * @Description
 * @Author Eytins
 * @Create 2021/5/12 13:59
 */

public interface HostService {
    /**
     * 向表中添加新主机
     *
     * @param host
     * @return
     */
    boolean addHost(Host host);

    /**
     * 搜索全部主机
     *
     * @return
     */
    List<Host> queryHost();

    /**
     * 根据id删除主机
     *
     * @param id
     */
    void deleteHost(Long id);

    /**
     * 测试主机是否能正常连接
     *
     * @param host
     * @return
     */
    boolean testHost(Host host);

    /**
     * 将主机添加到集群
     *
     * @param host
     * @return
     */
    Shell addHostToCluster(Host host);

    /**
     * 部署主机上名为dockerName的服务到集群
     *
     * @param host
     * @param dockerName  image名
     * @param insidePort  服务本身的端口
     * @param outsidePort 服务对外暴露的端口
     * @return
     */
    Shell deployService(Host host, String dockerName, int insidePort, int outsidePort);
}
