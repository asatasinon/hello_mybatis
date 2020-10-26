package com.sinon.hello.aop;

import com.sinon.hello.annotation.SuperDataSource;
import com.sinon.hello.config.datasource.DataSourceContextHolder;
import com.sinon.hello.utils.ApplicationContextProvider;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect
@Component
public class DataSourceAop {

    @Autowired
    private DataSourceContextHolder dataSourceContextHolder;

    //定义 切换主库 类切点
    @Pointcut("within(@com.sinon.hello.annotation.MasterDataSource *)")
    public void masterType() {
    }

    //定义 切换从库 类切点
    @Pointcut("within(@com.sinon.hello.annotation.SlaveDataSource *)")
    public void slaveType() {
    }

    //定义 切换主库 方法切点
    @Pointcut("@annotation(com.sinon.hello.annotation.MasterDataSource)")
    public void masterMethod() {
    }

    //定义 切换从库 方法切点
    @Pointcut("@annotation(com.sinon.hello.annotation.SlaveDataSource)")
    public void slaveMethod() {
    }

    //切换库
    @Around("masterType() || slaveType() || masterMethod() || slaveMethod()")
    public Object switchPoint(ProceedingJoinPoint joinPoint) throws Throwable {

        //获取类的字节码对象，通过字节码对象获取方法信息
        Class<?> targetCls = joinPoint.getTarget().getClass();
        //获取方法签名(通过此签名获取目标方法信息)
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        //获取目标方法上的注解指定的操作名称
        Method targetMethod = targetCls.getDeclaredMethod(ms.getName(), ms.getParameterTypes());

        /*
          这里要使用AnnotatedElementUtils
          如果还是用AnnotationUtils会发现注解的继承不起作用
          这个在AnnotationUtils类的英文文档中也有说明

          //SupperDataSource supperDataSource = AnnotationUtils.findAnnotation(targetMethod,SupperDataSource.class);
        */
        //获取 方法 的注解
        SuperDataSource superDataSource = AnnotatedElementUtils.findMergedAnnotation(targetMethod, SuperDataSource.class);

        //如果为空，则获取 类 的注解
        if (superDataSource == null) {
            superDataSource = AnnotatedElementUtils.findMergedAnnotation(targetCls, SuperDataSource.class);
        }
        //执行切换数据源
        dataSourceContextHolder.setDataSourceType(superDataSource.value(),
                ApplicationContextProvider.getBean(superDataSource.clazzDataBaseLoadBalance()));

        //执行操作
        Object result = joinPoint.proceed();

        //执行清除数据源的配置,防止后面的语句使用上一个语句 的 SqlConnection
        dataSourceContextHolder.clearDataSourceType();

        //不返回数据则会报错
        return result;
    }

}
