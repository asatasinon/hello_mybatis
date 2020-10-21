package com.sinon.hello.config.loadbalance.impl;


import com.sinon.hello.config.loadbalance.IDataSourceLoadBalance;
import com.sinon.hello.enums.DataSourceTypeEnum;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description 不使用负载均衡的实现类
 * @CreateDate 2020/10/19
 */

public class NoneDataSourceLoadBalanceImpl implements IDataSourceLoadBalance {
    @Override
    public int loadBalance(DataSourceTypeEnum dataSourceTypeEnum) {
        return dataSourceTypeEnum.getIndex();
    }
}
