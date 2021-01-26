package com.neu.ms.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * 这个配置类让mapper文件上不用加@Mapper注解了
 */
@Configuration
@MapperScan("com.neu.ms.mbg.mapper")
public class MyBatisConfig {
}