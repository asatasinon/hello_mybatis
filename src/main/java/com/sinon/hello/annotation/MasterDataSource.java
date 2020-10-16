package com.sinon.hello.annotation;

import com.sinon.hello.enums.BalanceTypeEnum;
import com.sinon.hello.enums.DataBaseTypeEnum;
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
    DataBaseTypeEnum value() default DataBaseTypeEnum.MASTER;

    //负载均衡策略
    @AliasFor(annotation = SupperDataSource.class, attribute = "balanceType")
    BalanceTypeEnum balanceType() default BalanceTypeEnum.ROUND_ROBIN;
}
