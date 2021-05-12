# 项目部署
## 数据库
### 数据库创建

``` sql
CREATE DATABASE `search`;
```

```sql
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `username` varchar(64)  NOT NULL COMMENT '用户名',
    `password` varchar(128)  NOT NULL COMMENT '密码',
    `email` varchar(128)  NULL DEFAULT NULL COMMENT '邮箱',
    `phone` varchar(32)  NULL DEFAULT NULL COMMENT '手机',
    `description` varchar(128)  NULL DEFAULT NULL COMMENT '描述',
    `roles` text CHARACTER SET utf8 COMMENT 'p0,p1,p2,p3',
    PRIMARY KEY (`id`) USING BTREE
)  DEFAULT CHARSET=utf8 COMMENT='用户表';


INSERT INTO `user` VALUES (0, 'admin', '$2a$10$RmAAjGU8xibRVukEsCiEyu9b3K2IFdJMHLxXbE1dmK4dJ4/oXBU6W', 'eytins@foxmail.com', '19822656367', '超级管理员', 'ROLE_p0');
COMMIT;
```

```sql
DROP TABLE IF EXISTS `host`;
CREATE TABLE `host` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主机id',
    `ip_address` varchar(128) NOT NULL COMMENT 'ip地址',
    `username` varchar(128) NOT NULL COMMENT '用户名',
    `password` varchar(128) NOT NULL COMMENT '密码',
    `description` varchar(128) NULL COMMENT '描述',
    PRIMARY KEY (`id`) USING BTREE
) DEFAULT CHARSET=utf8 COMMENT='主机表'
```