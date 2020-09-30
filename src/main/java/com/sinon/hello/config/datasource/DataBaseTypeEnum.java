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
public enum DataBaseTypeEnum {
    MASTER(1, true),
    MASTER_2(2, true),

    SLAVE(100, false),
    SLAVE_2(101, false);

    private int index;
    private boolean masterDatasource;

    DataBaseTypeEnum(int index, boolean masterDatasource) {
        this.index = index;
        this.masterDatasource = masterDatasource;
    }

    public static DataBaseTypeEnum getDataBaseType(int index) {
        for (DataBaseTypeEnum value : DataBaseTypeEnum.values()) {
            if (value.index == index) {
                return value;
            }
        }
        return MASTER;
    }

    public int getIndex() {
        return this.index;
    }

    public boolean isMasterDatasource() {
        return this.masterDatasource;
    }


}