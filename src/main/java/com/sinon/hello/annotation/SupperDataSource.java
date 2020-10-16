package com.sinon.hello.annotation;

import com.sinon.hello.enums.BalanceTypeEnum;
import com.sinon.hello.enums.DataBaseTypeEnum;
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
    DataBaseTypeEnum value() default DataBaseTypeEnum.MASTER;

    //负载均衡策略
    BalanceTypeEnum balanceType() default BalanceTypeEnum.ROUND_ROBIN;
}
