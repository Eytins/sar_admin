# 项目部署

## 开发指南

下载alibaba编码规范插件（尤其注意方法类等命名规范）

项目所用的常量都放在com.eytins.sar_admin.framework.constants.Enums（枚举）中，可以查看里面的常量是怎么用的

### Controller：

1. 正常开发的功能加上注解：@Profile({"dev", "default"})

2. 向Spring中注册Service采用如下方式：

   ```java
   public class HostController {
   
       final HostService hostService;
   
       public HostController(HostService hostService) {
           this.hostService = hostService;
       }
   ```

### Service

1. 向Spring中注册mapper采用如下方式：

   ```java
       final HostMapper hostMapper;
       final UserMapper userMapper;
   
       public HostServiceImpl(HostMapper hostMapper, UserMapper userMapper) {
           this.hostMapper = hostMapper;
           this.userMapper = userMapper;
       }
   ```

### Mapper

用到的话找刘明哲（超简单用法（不需要写sql语句））

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

```sql
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志id',
    `ip_address` varchar(128) NOT NULL COMMENT 'ip地址',
    `command` text NULL COMMENT '输入的命令',
    `message` text NULL COMMENT '输出的日志',
    `description` text NULL COMMENT '所做的操作',
    PRIMARY KEY (`id`) USING BTREE
) DEFAULT CHARSET=utf8 COMMENT='日志表'
```