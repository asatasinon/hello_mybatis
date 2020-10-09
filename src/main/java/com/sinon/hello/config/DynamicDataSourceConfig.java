package com.sinon.hello.config;

import com.sinon.hello.enums.DataBaseTypeEnum;
import com.sinon.hello.config.datasource.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description DataSourceConfig
 * @CreateDate 2020/9/28
 */

/**
 * 4.多数据源配置文件初始化
 */
@Configuration
public class DynamicDataSourceConfig {

    /**
     *  主库
     */
    // 将这个对象放入Spring容器中 , 并定义名称为 masterDataSource
    @Bean(name = "masterDataSource")
    // 表示这个数据源是默认数据源
    @Primary
    // 读取application.yml中的配置参数映射成为一个对象， prefix表示参数的前缀
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "master2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master2")
    public DataSource master2DataSource() {
        return DataSourceBuilder.create().build();
    }



    /**
     *  从库
     */
    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "slave2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave2")
    public DataSource slave2DataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * @param masterDataSource
     * @param master2DataSource
     * @param slaveDataSource
     * @param slave2DataSource
     * @return
     * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
     */
    @Bean(name = "routingDataSource")
    public DataSource routingDataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
                                        @Qualifier("master2DataSource") DataSource master2DataSource,
                                        @Qualifier("slaveDataSource") DataSource slaveDataSource,
                                        @Qualifier("slave2DataSource") DataSource slave2DataSource) {
        //这个地方是比较核心的targetDataSource 集合是我们数据库和名字之间的映射
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataBaseTypeEnum.MASTER, masterDataSource);
        targetDataSources.put(DataBaseTypeEnum.MASTER_2, master2DataSource);
        targetDataSources.put(DataBaseTypeEnum.SLAVE, slaveDataSource);
        targetDataSources.put(DataBaseTypeEnum.SLAVE_2, slave2DataSource);

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource);  // 设置默认的datasource
        dynamicDataSource.setTargetDataSources(targetDataSources);  // 该方法是AbstractRoutingDataSource的方法
        return dynamicDataSource;
    }

    /**
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory SqlSessionFactory(@Qualifier("routingDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 设置我们的xml文件路径, 就不用配置文件里的
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources("classpath:com.sinon.hello.mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

}
