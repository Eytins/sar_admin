package com.eytins.sar_admin.service.impl;

import com.eytins.sar_admin.dao.HostMapper;
import com.eytins.sar_admin.entity.Host;
import com.eytins.sar_admin.framework.constants.Enums;
import com.eytins.sar_admin.framework.ssh.Shell;
import com.eytins.sar_admin.service.HostService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Description
 * @Author Eytins
 * @Create 2021/5/12 13:59
 */

@Service
public class HostServiceImpl implements HostService {

    final HostMapper hostMapper;

    public HostServiceImpl(HostMapper hostMapper) {
        this.hostMapper = hostMapper;
    }

    @Override
    public boolean addHost(Host host) {
        Example example = new Example(Host.class);
        example.createCriteria().andEqualTo("ip_address", host.getIpAddress());
        //去Enums里查看是否需要验证主机重复
        if (Enums.IF_VERIFY_HOST.getCode() == 1) {
            if (hostMapper.selectByExample(example) != null) {
                return false;
            } else {
                hostMapper.insert(host);
                return true;
            }
        } else {
            hostMapper.insert(host);
            return true;
        }
    }

    @Override
    public List<Host> queryHost() {
        return hostMapper.selectAll();
    }

    @Override
    public void deleteHost(Long id) {
        Host host = new Host();
        host.setId(id);
        hostMapper.deleteByPrimaryKey(host);
    }

    @Override
    public boolean testHost(Host host) {
        Shell shell = new Shell(host.getUsername(), host.getPassword(), host.getIpAddress());
        int exitCode = shell.exec("ls");
        return exitCode == 0;
    }

    @Override
    public Shell addHostToCluster(Host host) {
        Shell shell = new Shell(host.getUsername(), host.getPassword(), host.getIpAddress());
        shell.exec("docker swarm join --token " +
                Enums.SERVER_TOKEN.getString() + " " +
                Enums.SERVER_IP.getString() + ":" +
                Enums.SERVER_PORT);
        return shell;
    }

    @Override
    public Shell deployService(Host host, String dockerName, int insidePort, int outsidePort) {
        Shell shell = new Shell(host.getUsername(), host.getPassword(), host.getIpAddress());
        shell.exec("docker service create -p " +
                outsidePort + ":" +
                insidePort + " " +
                dockerName);
        return null;
    }

}
