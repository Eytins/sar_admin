package com.eytins.sar_admin.service.impl;

import com.eytins.sar_admin.dao.UserMapper;
import com.eytins.sar_admin.entity.User;
import com.eytins.sar_admin.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Eytins
 * @Create 2021/5/11 21:53
 */

@Service
public class UserServiceImpl implements UserService {

    final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean addUser(User user) {
        if (userMapper.queryByUserName(user.getUsername()) != null) {
            return false;
        } else {
            userMapper.insert(user);
            return true;
        }
    }
}
