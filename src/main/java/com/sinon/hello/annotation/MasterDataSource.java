package com.sinon.hello.annotation;

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
}
