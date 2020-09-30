package com.sinon.hello.annotation;

import com.sinon.hello.config.datasource.DataBaseType;

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
    DataBaseType value() default DataBaseType.MASTER;
    //是否启用负载均衡
    boolean isBalance() default  true;
}
