package com.sinon.hello.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description DynamicDataSource
 * @CreateDate 2020/9/28
 */

/**
 * 3 利用 DataSourceContextHolder 获取当前线程的 datasourcetype
 * 动态数据源（需要继承AbstractRoutingDataSource）
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private DynamicDataSource() {
    }

    private static volatile DynamicDataSource instance;

    private DataSourceContextHolder dataSourceContextHolder;

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceContextHolder.getDataSourceType();
    }

    public static DynamicDataSource getInstance() {
        if (instance == null) {
            synchronized (DynamicDataSource.class) {
                if (instance == null) {
                    instance = new DynamicDataSource();
                }
            }
        }
        return instance;
    }

    public void setDataSourceContextHolder(DataSourceContextHolder dataSourceContextHolder) {
        this.dataSourceContextHolder = dataSourceContextHolder;
    }
}