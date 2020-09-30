package com.sinon.hello.config.datasource;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description DataBaseContextHolder
 * @CreateDate 2020/9/28
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2. 创建线程安全的类，作为dataBaseType容器，放master，master2,slave,slave2.由于从库有两个，这里简单设置了一个负载均衡。
 */
@Component
public class DataBaseContextHolder {
    // ThreadLocal
    private static final ThreadLocal<DataBaseType> CONTEXT_HOLDER = new ThreadLocal<>();
    private static final AtomicInteger CONTER_MASTER = new AtomicInteger(0);
    private static final AtomicInteger COUNTER_SLAVE = new AtomicInteger(0);
    //主库起始点为 1
    private static final int MASTER_PREFIX = 1;
    //从库起始点为 100。
    private static final int SLAVE_PREFIX = 100;

    @Value("${slavedatasourcecount.num}")
    private int slaveNum;

    @Value("${masterdatasourcecount.num}")
    private int masterNum;


    /**
     * 根据传入的 DataBaseType 切换 数据源
     * @param dataBaseType
     */
    public void setDataBaseType(DataBaseType dataBaseType) throws NullPointerException {
        CONTEXT_HOLDER.set(dataBaseType);
        System.out.println("=====================> 切换到 "+ dataBaseType.name());
    }

    /**
     * 获取当前的 数据源
     * @return
     */
    public DataBaseType getDataBaseType() {
        return CONTEXT_HOLDER.get() == null ? DataBaseType.MASTER : CONTEXT_HOLDER.get();
    }

    /**
     * 切换至 默认的主库
     */
    public void setDataBaseMaster(DataBaseType dataBaseType, boolean isBalance) {
        //是否启用负载均衡，如果不启用，则使用 dataBaseType 库
        if(isBalance) {
            // 负载均衡 , 轮询
            int num = CONTER_MASTER.getAndIncrement() % masterNum;
            if (CONTER_MASTER.get() > 1000) {
                CONTER_MASTER.set(0);
            }
            int index = MASTER_PREFIX + num;
            setDataBaseType(DataBaseType.getDataBaseType(index));
        } else {
            setDataBaseType(dataBaseType);
        }
    }

    /**
     * 切换从库
     * @param isBalance  是否启用负载均衡
     */
    public void setDataBaseSlave(DataBaseType dataBaseType, boolean isBalance) {
        //是否启用负载均衡，如果不启用，则使用 dataBaseType 库
        if(isBalance) {
            // 负载均衡 , 轮询
            int num = COUNTER_SLAVE.getAndIncrement() % slaveNum;
            if (COUNTER_SLAVE.get() > 1000) {
                COUNTER_SLAVE.set(0);
            }
            int index = SLAVE_PREFIX + num;
            setDataBaseType(DataBaseType.getDataBaseType(index));
        } else {
            setDataBaseType(dataBaseType);
        }
    }

    // 清空数据源
    public void clearDataBaseType() {
        CONTEXT_HOLDER.remove();
    }
}