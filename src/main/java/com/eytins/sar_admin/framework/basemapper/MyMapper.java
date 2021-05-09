package com.eytins.sar_admin.framework.basemapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Description 为MySQL准备的tkBaseMapper
 * @Author Eytins
 * @Create 2021/5/9 18:28
 */

public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
