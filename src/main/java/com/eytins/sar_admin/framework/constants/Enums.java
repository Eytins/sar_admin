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
    DEFAULT_SSH_PORT(22, ""),
    /**
     * 定义在添加主机时是否需要检查重复（1为需要，0为不需要）
     */
    IF_VERIFY_HOST(1, ""),
    /**
     * 集群master节点的公网ip
     */
    SERVER_IP(0, "112.124.54.71"),
    /**
     * 集群master节点给worker节点访问的端口
     */
    SERVER_PORT(0, "2377"),
    /**
     * 集群master节点的token
     */
    SERVER_TOKEN(0, "SWMTKN-1-0fi2253o1ipt5jxa67xon2s6bu60jljvk12upjjtry128m74cd-166fuw4c022gb7c12e3bx6nt4");

    @Getter
    private final int code;

    @Getter
    private final String string;

    Enums(int code, String message) {
        this.code = code;
        this.string = message;
    }

}
