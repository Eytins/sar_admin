package com.eytins.sar_admin.dao;

import com.eytins.sar_admin.entity.User;
import com.eytins.sar_admin.framework.basemapper.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
     * 如果有复杂的多表查询任务再去建mapper
     * @param username 用户名
     * @return 无
     */
    @Select("SELECT * FROM user WHERE username=#{username}")
    User queryByUserName(@Param("username") String username);
}
