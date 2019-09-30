package com.example.demoWebflux.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .password("password")
                .username("root")
                .url("jdbc:mysql://127.0.0.1:3306/ec_courier?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8")
                .driverClassName("com.mysql.jdbc.Driver")
                .build();
    }
}