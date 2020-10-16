package com.sinon.hello.annotation;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description SlaveDataSouce
 * @CreateDate 2020/9/28
 */

import com.sinon.hello.enums.BalanceTypeEnum;
import com.sinon.hello.enums.DataBaseTypeEnum;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SupperDataSource
public @interface SlaveDataSource {
    @AliasFor(annotation = SupperDataSource.class, attribute = "value")
    DataBaseTypeEnum value() default DataBaseTypeEnum.SLAVE;

    //负载均衡策略
    @AliasFor(annotation = SupperDataSource.class, attribute = "balanceType")
    BalanceTypeEnum balanceType() default BalanceTypeEnum.ROUND_ROBIN;
}
