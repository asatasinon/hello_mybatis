package com.sinon.hello.annotation;

import com.sinon.hello.config.datasource.BalanceTypeEnum;
import com.sinon.hello.config.datasource.DataBaseTypeEnum;

import java.lang.annotation.*;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description MasterDataSource
 * @CreateDate 2020/9/28
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MasterDataSource {
    // 默认为主库 MASTER
    DataBaseTypeEnum value() default DataBaseTypeEnum.MASTER;

    //负载均衡策略
    BalanceTypeEnum balanceType() default BalanceTypeEnum.ROUND_ROBIN;
}
