package com.sinon.hello.annotation;

import com.sinon.hello.config.loadbalance.IDataSourceLoadBalance;
import com.sinon.hello.config.loadbalance.impl.NoneDataSourceLoadBalanceImpl;
import com.sinon.hello.enums.BalanceTypeEnum;
import com.sinon.hello.enums.DataSourceTypeEnum;
import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description SupperDataSource
 * @CreateDate 2020/10/16
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Indexed
public @interface SupperDataSource {
    // 默认为主库 MASTER
    DataSourceTypeEnum value() default DataSourceTypeEnum.MASTER;

    //负载均衡策略实现类
    Class<? extends IDataSourceLoadBalance> clazzDataBaseLoadBalance() default NoneDataSourceLoadBalanceImpl.class;
}
