package com.sinon.hello.config.datasource;

import com.sinon.hello.enums.BalanceTypeEnum;
import com.sinon.hello.enums.DataBaseTypeEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description DataSourceLoadBalanceFactory
 * @CreateDate 2020/9/30
 */
@Component
public class DataSourceLoadBalanceFactory {

    /**
     * 阈值
     */
    private static final int COUNTER_THRESHOLD = 100000;

    /**
     * 初始值为0
     */
    private static final int COUNTER_START = 0;

    /**
     * 初始化
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

    /**
     * 负载均衡策略工场
     *
     * @param dataBaseTypeEnum 数据源类型
     * @param balanceTypeEnum  负载均衡策略类型
     * @return 使用策略负载均衡后的节点
     */
    public int loadBalance(DataBaseTypeEnum dataBaseTypeEnum, BalanceTypeEnum balanceTypeEnum) {
        switch (balanceTypeEnum) {
            case RANDOM:
                return randomBalance(dataBaseTypeEnum);
            case ROUND_ROBIN:
                return roundRobinBalance(dataBaseTypeEnum);
            default:
                return dataBaseTypeEnum.getIndex();
        }
    }

    /**
     * 轮询策略
     *
     * @param dataBaseTypeEnum 数据库类型
     * @return 节点
     */
    private int roundRobinBalance(DataBaseTypeEnum dataBaseTypeEnum) {
         /*
         COUNTER 先自增 +1, 再对 数据库节点数 取模
        */
        //主库节点
        if (dataBaseTypeEnum.isMasterDatasource()) {
            int masterIndex = COUNTER_MASTER.getAndIncrement() % masterNum;
            if (COUNTER_MASTER.get() > COUNTER_THRESHOLD) {
                //超过阈值，重置
                COUNTER_MASTER.set(COUNTER_START);
            }
            return MASTER_PREFIX + masterIndex;
        }

        //从库节点
        int slaveIndex = COUNTER_SLAVE.getAndIncrement() % slaveNum;
        if (COUNTER_SLAVE.get() > COUNTER_THRESHOLD) {
            COUNTER_SLAVE.set(COUNTER_START);
        }
        return SLAVE_PREFIX + slaveIndex;
    }

    /**
     * 随机策略
     *
     * @param dataBaseTypeEnum 数据库类型
     * @return 节点
     */
    private int randomBalance(DataBaseTypeEnum dataBaseTypeEnum) {
        //随机种子
        Random r = new Random();
        if (dataBaseTypeEnum.isMasterDatasource()) {
            return MASTER_PREFIX + r.nextInt(masterNum);
        }
        return SLAVE_PREFIX + r.nextInt(masterNum);
    }

}
