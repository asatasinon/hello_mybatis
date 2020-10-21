package com.sinon.hello.config.loadbalance;


import com.sinon.hello.enums.DataSourceTypeEnum;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description 负载均衡接口类
 * @CreateDate 2020/10/19
 */

public interface IDataSourceLoadBalance {
    int loadBalance(DataSourceTypeEnum dataSourceTypeEnum);
}
