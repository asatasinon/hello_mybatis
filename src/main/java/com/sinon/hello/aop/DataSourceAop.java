package com.sinon.hello.aop;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description DataSourceAop
 * @CreateDate 2020/9/28
 */


import com.sinon.hello.config.datasource.DataBaseContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class DataSourceAop {

    @Pointcut()
    public void master(){}

    @Pointcut()
    public void slave(){}

    @Before("@annotation(com.sinon.hello.annotation.SlaveDataSource)")
    public void slavePoint() {
        DataBaseContextHolder.setDataBaseSlave();
    }


    @Before("@annotation(com.sinon.hello.annotation.MasterDataSource)")
    public void masterPoint() {
        DataBaseContextHolder.setDataBaseMaster();
    }

    //清除数据源的配置, 多个切点
    @After("@annotation(com.sinon.hello.annotation.MasterDataSource) || @annotation(com.sinon.hello.annotation.SlaveDataSource) ")
    public void restoreDataSource(JoinPoint joinPoint) {
        DataBaseContextHolder.clearDataBaseType();
    }


}
