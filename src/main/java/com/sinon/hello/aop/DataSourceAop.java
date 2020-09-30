package com.sinon.hello.aop;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description DataSourceAop
 * @CreateDate 2020/9/28
 */


import com.sinon.hello.annotation.MasterDataSource;
import com.sinon.hello.annotation.SlaveDataSource;
import com.sinon.hello.config.datasource.DataBaseContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.omg.CORBA.TCKind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class DataSourceAop {

    @Autowired
    private DataBaseContextHolder dataBaseContextHolder;

    //定义 切换主库 切点
    @Pointcut("@annotation(com.sinon.hello.annotation.MasterDataSource)")
    public void master() {
    }

    //定义 切换从库 切点
    @Pointcut("@annotation(com.sinon.hello.annotation.SlaveDataSource)")
    public void slave() {
    }

    //根据 masterDataSource.value() 切换至对应的主库链接
    @Before("master() && @annotation(masterDataSource) ")
    public void masterPoint(JoinPoint joinPoint, MasterDataSource masterDataSource) {
        try {
            dataBaseContextHolder.setDataBase(masterDataSource.value(), masterDataSource.balanceType());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //切换从库
    @Before("slave() && @annotation(slaveDataSource)")
    public void slavePoint(JoinPoint joinPoint, SlaveDataSource slaveDataSource) {
        try {
            dataBaseContextHolder.setDataBase(slaveDataSource.value(), slaveDataSource.balanceType());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    //清除数据源的配置, 多个切点
    @After("master() || slave()")
    public void restoreDataSource(JoinPoint joinPoint) {
        dataBaseContextHolder.clearDataBaseType();
    }


}
