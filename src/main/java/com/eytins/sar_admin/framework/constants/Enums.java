package com.eytins.sar_admin.framework.constants;

import lombok.Getter;

/**
 * @Description 用于存储项目所用到的常量的枚举类
 * @Author Eytins
 * @Create 2021/5/13 0:58
 */

public enum Enums {
    /**
     * ssh连接默认端口
     */
    DEFAULT_SSH_PORT(22);

    @Getter
    private final int code;

    Enums(int code) {
        this.code = code;
    }

}
