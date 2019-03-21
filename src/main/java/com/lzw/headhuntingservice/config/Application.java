package com.lzw.headhuntingservice.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = "classpath:jdbc.properties")
@ComponentScan(basePackages = "com.lzw")
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.driverClassName}")
    private String jdbcDriverClassName;

    @Value("${jdbc.username}")
    private String jdbcUsername;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    //数据源
    @Bean
    public DataSource dataSource(){
        PooledDataSource pooledDataSource=new PooledDataSource();
        pooledDataSource.setDriver(jdbcDriverClassName);
        pooledDataSource.setUrl(jdbcUrl);
        pooledDataSource.setUsername(jdbcUsername);
        pooledDataSource.setPassword(jdbcPassword);
        return pooledDataSource;
    }



    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(Application.class);
    }





}
