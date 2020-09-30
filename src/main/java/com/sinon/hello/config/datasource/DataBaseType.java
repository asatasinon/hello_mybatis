package com.sinon.hello.config.datasource;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description DatabaseType
 * @CreateDate 2020/9/28
 */

/**
 * 1.定义枚举类数据源类型   key
 * 主库 为 1-99 按 +1 递增
 * 从库 为 100-999 按 +1 递增
 */
public enum DataBaseType {
    MASTER(1),
    MASTER_2(2),

    SLAVE(100),
    SLAVE_2(101);

    private int index;

    DataBaseType(int index) {
        this.index = index;
    }

    public static DataBaseType getDataBaseType(int index) {
        for (DataBaseType value : DataBaseType.values()) {
            if (value.index == index) {
                return value;
            }
        }
        return MASTER;
    }
}