package com.sinon.hello.config.datasource;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description DataBaseContextHolder
 * @CreateDate 2020/9/28
 */

import com.sinon.hello.enums.BalanceTypeEnum;
import com.sinon.hello.enums.DataBaseTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Stack;

/**
 * 2. 创建线程安全的类，作为dataBaseType容器，放master，master2,slave,slave2.由于从库有两个，这里简单设置了一个负载均衡。
 */
@Component
public class DataBaseContextHolder {
    /**
     * 使用 ThreadLocal，保存线程安全
     * 使用 Stack<DataBaseTypeEnum>，保存同一线程内多次切换的数据源，
     * 防止AOP切点执行完后执行清空数据源配置，将数据源配置变成了 DataBaseTypeEnum.MASTER
     */
    private static final ThreadLocal<Stack<DataBaseTypeEnum>> CONTEXT_HOLDER = new ThreadLocal<>();

    @Autowired
    private DataSourceLoadBalanceFactory dataSourceLoadBalanceFactory;

    /**
     * 根据传入的 dataBaseTypeEnum 切换 数据源
     *
     * @param dataBaseTypeEnum DataBaseTypeEnum
     */
    public void setDataBaseType(DataBaseTypeEnum dataBaseTypeEnum) throws NullPointerException {
        if (CONTEXT_HOLDER.get() == null) {
            CONTEXT_HOLDER.set(new Stack<>());
        }
        CONTEXT_HOLDER.get().push(dataBaseTypeEnum);
        System.out.println("=====================> 切换到 " + dataBaseTypeEnum.name());
    }

    /**
     * 获取当前的数据源
     * <p>
     * 手动处理NULL值，避免NPE，
     * 如果不手动处理NULL值,直接返回 CONTEXT_HOLDER.get()，
     * 需要在 DynamicDataSourceConfig 类里的 routingDataSource 方法
     * 配置 dynamicDataSource.setDefaultTargetDataSource(masterDataSource);
     * </p>
     *
     * @return 默认值 DataBaseTypeEnum.MASTER
     */
    public DataBaseTypeEnum getDataBaseType() {
        //如果栈 为null 或 为空，则返回 DataBaseTypeEnum.MASTER;
        if (CONTEXT_HOLDER.get() == null || CONTEXT_HOLDER.get().isEmpty()) {
            return DataBaseTypeEnum.MASTER;
        }
        // 如果栈不为空，则取栈顶元素
        return CONTEXT_HOLDER.get().peek();
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
        CONTEXT_HOLDER.get().pop();
    }
}