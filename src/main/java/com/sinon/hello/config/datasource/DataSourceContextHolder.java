package com.sinon.hello.config.datasource;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description DataBaseContextHolder
 * @CreateDate 2020/9/28
 */

import com.sinon.hello.config.loadbalance.IDataSourceLoadBalance;
import com.sinon.hello.enums.BalanceTypeEnum;
import com.sinon.hello.enums.DataSourceTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Stack;

/**
 * 2. 创建线程安全的类，作为dataBaseType容器，放master，master2,slave,slave2.由于从库有两个，这里简单设置了一个负载均衡。
 */
@Component
public class DataSourceContextHolder {
    /**
     * 使用 ThreadLocal，保存线程安全
     * 使用 Stack<DataBaseTypeEnum>，保存同一线程内多次切换的数据源，
     * 防止AOP切点执行完后执行清空数据源配置，将数据源配置变成了 DataBaseTypeEnum.MASTER
     */
    private static final ThreadLocal<Stack<DataSourceTypeEnum>> CONTEXT_HOLDER = new ThreadLocal<>();



    /**
     * 根据传入的 dataBaseTypeEnum 切换 数据源
     *
     * @param dataSourceTypeEnum DataBaseTypeEnum
     */
    public void setDataSourceType(DataSourceTypeEnum dataSourceTypeEnum) throws NullPointerException {
        if (CONTEXT_HOLDER.get() == null) {
            CONTEXT_HOLDER.set(new Stack<>());
        }
        CONTEXT_HOLDER.get().push(dataSourceTypeEnum);
        System.out.println("=====================> 切换到 " + dataSourceTypeEnum.name());
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
    public DataSourceTypeEnum getDataSourceType() {
        //如果栈 为null 或 为空，则返回 DataBaseTypeEnum.MASTER;
        if (CONTEXT_HOLDER.get() == null || CONTEXT_HOLDER.get().isEmpty()) {
            return DataSourceTypeEnum.MASTER;
        }
        // 如果栈不为空，则取栈顶元素
        return CONTEXT_HOLDER.get().peek();
    }

    /**
     * 根据负载均衡策略切换主库
     *
     * @param dataSourceTypeEnum 指定切换的主库库节点
     * @param dataSourceLoadBalance  负载均衡策略
     */
    public void setDataSourceType(DataSourceTypeEnum dataSourceTypeEnum, IDataSourceLoadBalance dataSourceLoadBalance) {
        int index = dataSourceLoadBalance.loadBalance(dataSourceTypeEnum);
        setDataSourceType(DataSourceTypeEnum.getDataSourceType(index));
    }

    /**
     * 将栈顶数据源出栈，防止后面的调用 使用了 上一次 的 数据库
     */
    public void clearDataSourceType() {
        //Stack不为null且不为空，则将栈顶数据源出栈
        if (CONTEXT_HOLDER.get() != null && !CONTEXT_HOLDER.get().isEmpty()) {
            CONTEXT_HOLDER.get().pop();
        }
    }
}