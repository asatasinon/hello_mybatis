package com.sinon.hello.config.datasource;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description DataBaseContextHolder
 * @CreateDate 2020/9/28
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2. 创建线程安全的类，作为dataBaseType容器，放master，master2,slave,slave2.由于从库有两个，这里简单设置了一个负载均衡。
 */
@Component
public class DataBaseContextHolder {
    /**
     * 使用 ThreadLocal，保存线程安全
     */
    private static final ThreadLocal<DataBaseTypeEnum> CONTEXT_HOLDER = new ThreadLocal<>();

    @Autowired
    private DataSourceLoadBalanceFactory dataSourceLoadBalanceFactory;

    /**
     * 根据传入的 dataBaseTypeEnum 切换 数据源
     *
     * @param dataBaseTypeEnum DataBaseTypeEnum
     */
    public void setDataBaseType(DataBaseTypeEnum dataBaseTypeEnum) throws NullPointerException {
        CONTEXT_HOLDER.set(dataBaseTypeEnum);
        System.out.println("=====================> 切换到 " + dataBaseTypeEnum.name());
    }

    /**
     * 获取当前的数据源
     *
     * @return 默认值为 DataBaseTypeEnum.MASTER
     */
    public DataBaseTypeEnum getDataBaseType() {
        return CONTEXT_HOLDER.get() == null ? DataBaseTypeEnum.MASTER : CONTEXT_HOLDER.get();
    }

    /**
     * 根据负载均衡策略切换主库
     *
     * @param dataBaseTypeEnum 指定切换的主库库节点
     * @param balanceTypeEnum  负载均衡策略
     */
    public void setDataBase(DataBaseTypeEnum dataBaseTypeEnum, BalanceTypeEnum balanceTypeEnum) {
        int index = dataSourceLoadBalanceFactory.loadBalance(dataBaseTypeEnum, balanceTypeEnum);
        setDataBaseType(DataBaseTypeEnum.getDataBaseType(index));
    }

    /**
     * 清空数据源，防止后面的调用 使用了 上一次 的 数据库
     */
    public void clearDataBaseType() {
        CONTEXT_HOLDER.remove();
    }

}