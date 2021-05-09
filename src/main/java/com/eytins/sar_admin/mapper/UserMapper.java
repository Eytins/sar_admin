package com.eytins.sar_admin.mapper;

import com.eytins.sar_admin.dao.User;
import com.eytins.sar_admin.framework.basemapper.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description 查找用户表所使用的Mapper（仅限查找用户表）
 * @Author Eytins
 * @Create 2021/5/9 17:58
 */

@Repository
public interface UserMapper extends MyMapper<User> {

    /**
     * 根据用户名查找用户类（这是自定义的方法【用query】，但tk中也有这种方法【用select】，防止混淆）
     * 如果加@Select("")注解，可以不用写mapper.xml，但失去了接口的意义，并且xml中写有提示
     * @param username 用户名
     * @return 无
     */
    User queryByUserName(@Param("username") String username);
}
