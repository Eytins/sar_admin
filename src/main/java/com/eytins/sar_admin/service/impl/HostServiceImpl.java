package com.eytins.sar_admin.service.impl;

import com.eytins.sar_admin.dao.HostMapper;
import com.eytins.sar_admin.entity.Host;
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
        if (hostMapper.selectByExample(example) != null) {
            return false;
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
}
