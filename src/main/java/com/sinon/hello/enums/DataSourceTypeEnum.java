package com.sinon.hello.enums;

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
public enum DataSourceTypeEnum {
    MASTER(1, DataBaseTypeEnum.MASTER_TYPE),
    MASTER_2(2, DataBaseTypeEnum.MASTER_TYPE),

    SLAVE(100, DataBaseTypeEnum.SLAVE_TYPE),
    SLAVE_2(101, DataBaseTypeEnum.SLAVE_TYPE);

    private int index;
    private DataBaseTypeEnum dataBaseTypeEnum;

    DataSourceTypeEnum(int index, DataBaseTypeEnum dataBaseTypeEnum) {
        this.index = index;
        this.dataBaseTypeEnum = dataBaseTypeEnum;
    }

    public static DataSourceTypeEnum getDataSourceType(int index) {
        for (DataSourceTypeEnum value : DataSourceTypeEnum.values()) {
            if (value.index == index) {
                return value;
            }
        }
        return MASTER;
    }

    public int getIndex() {
        return this.index;
    }

    public DataBaseTypeEnum getDataBaseTypeEnum() {
        return dataBaseTypeEnum;
    }



}