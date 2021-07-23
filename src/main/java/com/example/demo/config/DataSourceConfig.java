package com.example.demo.config;

import com.example.demo.commons.myenums.DBTypeEnum;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    /**
     * 配置主数据库数据源
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.datasource.master")
    public DataSource masterDataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * 配置从数据库数据源
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.datasource.slave")
    public DataSource slaveDataSource(){
        return DataSourceBuilder.create().build();
    }


    /**
     * 路由数据库，用来通用管理数据源。
     * @param masterDataSource
     * @param slaveDataSource
     * @return
     */
    @Bean
    public DataSource myRoutingDataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
                                          @Qualifier("slaveDataSource") DataSource slaveDataSource){

        Map<Object,Object> targetObjectMap = new HashMap<>();

        targetObjectMap.put(DBTypeEnum.MASTER,masterDataSource);

        targetObjectMap.put(DBTypeEnum.SALVE,slaveDataSource);

        MyRoutingDataSource myRoutingDataSource = new MyRoutingDataSource();

//        设置默认的数据源为master
        myRoutingDataSource.setDefaultTargetDataSource(masterDataSource);

        myRoutingDataSource.setTargetDataSources(targetObjectMap);

        return myRoutingDataSource;
    }

}
