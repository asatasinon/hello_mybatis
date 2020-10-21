package com.sinon.hello.config.loadbalance.impl;

import com.sinon.hello.config.loadbalance.IDataSourceLoadBalance;
import com.sinon.hello.enums.DataSourceTypeEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description RoundRobinDataSourceLoadBalanceImpl
 * @CreateDate 2020/10/20
 */
@Component
public class RoundRobinDataSourceLoadBalanceImpl implements IDataSourceLoadBalance {

    /**
     * 初始值为 0
     */
    private static final int COUNTER_START = 0;

    /**
     * 阈值为 10000
     */
    private static final int COUNTER_THRESHOLD = 10000;

    /**
     * 初始值为 COUNTER_START
     */
    private static final AtomicInteger COUNTER_MASTER = new AtomicInteger(COUNTER_START);
    private static final AtomicInteger COUNTER_SLAVE = new AtomicInteger(COUNTER_START);
    /**
     * 主库起始点为 1
     */
    private static final int MASTER_PREFIX = 1;
    /**
     * 从库起始点为 100。
     */
    private static final int SLAVE_PREFIX = 100;
    /**
     * 主库节点数
     */
    @Value("${master-datasource-count.num}")
    private int masterNum;
    /**
     * 从库节点数
     */
    @Value("${slave-datasource-count.num}")
    private int slaveNum;

    @Override
    public int loadBalance(DataSourceTypeEnum dataSourceTypeEnum) {
      /*
         COUNTER 先自增 +1, 再对 数据库节点数 取模
        */
        int masterIndex = 0;
        int slaveIndex = 0;
        switch (dataSourceTypeEnum) {
            //主库节点
            case MASTER:
                masterIndex = COUNTER_MASTER.getAndIncrement() % masterNum;
                if (COUNTER_MASTER.get() > COUNTER_THRESHOLD) {
                    COUNTER_MASTER.set(COUNTER_START);
                }
                return MASTER_PREFIX + masterIndex;
            //从库节点
            case SLAVE:
                slaveIndex = COUNTER_SLAVE.getAndIncrement() % slaveNum;
                if (COUNTER_SLAVE.get() > COUNTER_THRESHOLD) {
                    COUNTER_SLAVE.set(COUNTER_START);
                }
                return SLAVE_PREFIX + slaveIndex;
            default:
                return MASTER_PREFIX + masterIndex;
        }
    }
}
