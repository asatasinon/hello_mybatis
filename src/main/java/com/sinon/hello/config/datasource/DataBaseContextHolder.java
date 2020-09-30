package com.sinon.hello.config.datasource;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description DataBaseContextHolder
 * @CreateDate 2020/9/28
 */

import com.sinon.hello.annotation.MasterDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2. 创建线程安全的类，作为dataBaseType容器，放master，master2,slave,slave2.由于从库有两个，这里简单设置了一个负载均衡。
 */
@Component
public class DataBaseContextHolder {
    // ThreadLocal
    private static final ThreadLocal<DataBaseType> contextHolder = new ThreadLocal<>();
    private static final AtomicInteger counter = new AtomicInteger(0);

    //从库起始点为 100。
    private static final int SLAVE_PREFIX = 100;

    @Value("${slavecount.num}")
    private int slaveNum;

    @Value("${mastercount.num}")
    private int masterNum;


    /**
     * 根据传入的 DataBaseType 切换 数据源
     * @param dataBaseType
     */
    public void setDataBaseType(DataBaseType dataBaseType) throws NullPointerException {
        contextHolder.set(dataBaseType);
        System.out.println("=====================> 切换到 "+ dataBaseType.name());
    }

    /**
     * 获取当前的 数据源
     * @return
     */
    public DataBaseType getDataBaseType() {
        return contextHolder.get() == null ? DataBaseType.MASTER : contextHolder.get();
    }

    /**
     * 切换至 默认的主库
     */
    public void setDataBaseMaster() {
        setDataBaseType(DataBaseType.MASTER);
        System.out.println("=====================> 切换到 master");
    }

    /**
     * 切换从库
     * @param isBalance  是否启用负载均衡
     */
    public void setDataBaseSlave(boolean isBalance) {
        //是否启用负载均衡，如果不启用，则默认为 SLAVE 库
        if(isBalance) {
            // 负载均衡 , 轮询
            int num = counter.getAndIncrement() % slaveNum;
            if (counter.get() > 1000) {
                counter.set(0);
            }
            int index = SLAVE_PREFIX + num;
            setDataBaseType(DataBaseType.getDataBaseType(index));
        } else {
            setDataBaseType(DataBaseType.SLAVE);
        }
    }

    // 清空数据源
    public void clearDataBaseType() {
        contextHolder.remove();
    }
}