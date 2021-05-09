package com.eytins.sar_admin.service.impl;

import com.eytins.sar_admin.dao.User;
import com.eytins.sar_admin.mapper.UserMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Eytins
 * @Create 2021/5/9 17:56
 */

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserMapper userMapper;

    public UserDetailServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.queryByUserName(s);
        if (user==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()));
        return user;
    }
}
