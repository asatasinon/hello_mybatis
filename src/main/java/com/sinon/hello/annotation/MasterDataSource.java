package com.sinon.hello.annotation;

import com.sinon.hello.config.loadbalance.IDataSourceLoadBalance;
import com.sinon.hello.config.loadbalance.impl.NoneDataSourceLoadBalanceImpl;
import com.sinon.hello.enums.BalanceTypeEnum;
import com.sinon.hello.enums.DataSourceTypeEnum;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description MasterDataSource
 * @CreateDate 2020/9/28
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SupperDataSource
public @interface MasterDataSource {
    // 默认为主库 MASTER
    @AliasFor(annotation = SupperDataSource.class, attribute = "value")
    DataSourceTypeEnum value() default DataSourceTypeEnum.MASTER;

    //负载均衡策略实现类
    @AliasFor(annotation = SupperDataSource.class, attribute = "clazzDataBaseLoadBalance")
    Class<? extends IDataSourceLoadBalance> clazzDataBaseLoadBalance() default NoneDataSourceLoadBalanceImpl.class;
}
