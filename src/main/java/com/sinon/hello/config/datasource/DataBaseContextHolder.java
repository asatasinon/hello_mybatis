package com.sinon.hello.config.datasource;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description DataBaseContextHolder
 * @CreateDate 2020/9/28
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2. 创建线程安全的类，作为dataBaseType容器，放master,slave1,slave2.由于从库有两个，这里简单设置了一个负载均衡。
 */
public class DataBaseContextHolder {
    private static final ThreadLocal<DataBaseType> contextHolder = new ThreadLocal<>();
    private static final AtomicInteger counter = new AtomicInteger(-1);

    public static void setDataBaseType(DataBaseType dataBaseType) throws NullPointerException {
        contextHolder.set(dataBaseType);
    }

    public static DataBaseType getDataBaseType() {
        return contextHolder.get();
    }

    public static void setDataBaseMaster() {
        setDataBaseType(DataBaseType.master);
        System.out.println("=====================> 切换到master");
    }

    public static void setDataBaseSlave() {
        // 负载均衡
        int index = counter.getAndIncrement() % 2;
        if (counter.get() > 9999) {
            counter.set(-1);
        }
        if (index == 0) {
            setDataBaseType(DataBaseType.slave1);
            System.out.println("==================> 切换到slave1");
        } else {
            setDataBaseType(DataBaseType.slave2);
            System.out.println("==================> 切换到slave2");
        }
    }


    // 清空数据类型
    public static void clearDataBaseType() {
        contextHolder.remove();
    }
}