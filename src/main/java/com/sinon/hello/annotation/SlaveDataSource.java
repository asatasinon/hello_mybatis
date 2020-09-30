package com.sinon.hello.annotation;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description SlaveDataSouce
 * @CreateDate 2020/9/28
 */
import com.sinon.hello.config.datasource.DataBaseType;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface SlaveDataSource{
    DataBaseType value() default DataBaseType.SLAVE;
    //是否启用负载均衡
    boolean isBalance() default  true;
}
