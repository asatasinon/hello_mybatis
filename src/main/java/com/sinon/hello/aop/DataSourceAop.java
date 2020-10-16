package com.sinon.hello.aop;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description DataSourceAop
 * @CreateDate 2020/9/28
 */


import com.sinon.hello.annotation.SupperDataSource;
import com.sinon.hello.config.datasource.DataBaseContextHolder;
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
    private DataBaseContextHolder dataBaseContextHolder;

    //定义 切换主库 切点
    @Pointcut("@annotation(com.sinon.hello.annotation.MasterDataSource)")
    public void master() {
    }

    //定义 切换从库 切点
    @Pointcut("@annotation(com.sinon.hello.annotation.SlaveDataSource)")
    public void slave() {
    }

    //切换库
    @Around("master() || slave()")
    public Object slavePoint(ProceedingJoinPoint joinPoint) throws Throwable {

        //获取类的字节码对象，通过字节码对象获取方法信息
        Class<?> targetCls = joinPoint.getTarget().getClass();
        //获取方法签名(通过此签名获取目标方法信息)
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        //获取目标方法上的注解指定的操作名称
        Method targetMethod = targetCls.getDeclaredMethod(ms.getName(), ms.getParameterTypes());

        /*
          这里要使用AnnotatedElementUtils
          如果还是用AnnotationUtils会发现继承不起作用
          这个在AnnotationUtils类的英文文档中也有说明

          //SupperDataSource supperDataSource = AnnotationUtils.findAnnotation(targetMethod,SupperDataSource.class);
        */
        SupperDataSource supperDataSource = AnnotatedElementUtils.findMergedAnnotation(targetMethod, SupperDataSource.class);

        //执行切换数据源
        dataBaseContextHolder.setDataBase(supperDataSource.value(), supperDataSource.balanceType());

        //执行操作
        Object result = joinPoint.proceed();

        //执行清除数据源的配置,防止后面的语句使用上一个语句 的 SqlConnection
        dataBaseContextHolder.clearDataBaseType();

        //不返回数据则会报错
        return result;
    }

}
