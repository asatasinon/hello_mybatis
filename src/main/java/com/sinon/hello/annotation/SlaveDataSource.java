package com.sinon.hello.annotation;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description SlaveDataSouce
 * @CreateDate 2020/9/28
 */
import com.sinon.hello.enums.BalanceTypeEnum;
import com.sinon.hello.enums.DataBaseTypeEnum;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface SlaveDataSource{
    DataBaseTypeEnum value() default DataBaseTypeEnum.SLAVE;

    //负载均衡策略
    BalanceTypeEnum balanceType() default BalanceTypeEnum.ROUND_ROBIN;
}
