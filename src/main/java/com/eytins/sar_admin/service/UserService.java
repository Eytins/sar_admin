package com.eytins.sar_admin.service;

import com.eytins.sar_admin.entity.User;

/**
 * @Description
 * @Author Eytins
 * @Create 2021/5/11 21:50
 */

public interface UserService {

    /**
     * 向表中添加新用户
     * @param user
     * @return
     */
    boolean addUser(User user);

}
