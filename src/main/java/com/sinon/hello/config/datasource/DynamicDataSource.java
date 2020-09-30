package com.sinon.hello.config.datasource;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description DynamicDataSource
 * @CreateDate 2020/9/28
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

/**
 * 3 利用 DatabaseContextHolder 获取当前线程的 datasourcetype
 * 动态数据源（需要继承AbstractRoutingDataSource）
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Autowired
    private  DataBaseContextHolder dataBaseContextHolder;

    @Override
    protected Object determineCurrentLookupKey() {
        return dataBaseContextHolder.getDataBaseType();
    }
}