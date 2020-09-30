package com.sinon.hello.config.datasource;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description BalanceType
 * @CreateDate 2020/9/30
 */
public enum BalanceTypeEnum {
    //轮询
    ROUND_ROBIN,
    //加权轮询
    WEIGHTED_ROUND_ROBIN,
    //随机
    RANDOM,
    //加权随机
    WEIGHTED_RANDOM,
    //源IP地址 与 数据库 节点数 进行哈希计算， 结果为 相同IP访问的都是同一个数据库
    IP_HASH,
    //不使用负载均衡策略
    NONE
}
