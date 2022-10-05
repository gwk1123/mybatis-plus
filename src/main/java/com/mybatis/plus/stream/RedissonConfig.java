package com.mybatis.plus.stream;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
public class RedissonConfig {

    @Autowired
    private RedisProperties redisProperties;
//
//    @Bean
//    public RedissonClient redissonClient() {
//        Config config = new Config();
//        String node = redisProperties.getRedisson().getAddress();
//        String password = redisProperties.getRedisson().getPassword();
//        SingleServerConfig serverConfig = config.useSingleServer();
//        serverConfig.setAddress(node)
//                .setConnectionMinimumIdleSize(redisProperties.getRedisson().getConnectionMinimumIdleSize());
////                .setConnectionPoolSize(redisProperties.getRedisson().getConnectionPoolSize());
//        if(!StringUtils.isEmpty(password)){
//            serverConfig.setPassword(password);
//        }
//        //用"rediss://"来启用SSL连接
////        String node = "redis://106.75.115.170:6379";
////        SingleServerConfig serverConfig = config.useSingleServer();
////        serverConfig.setAddress(node);
////        serverConfig.setPassword("gwk_632697105qq@.redis");
//        return Redisson.create(config);
//    }

    private int connectionPoolSize = 64;
    private int timeout = 3000;

    /**
     * 单机模式
     */
    @Bean
    public RedissonClient redissonSingle() {
        Config config = new Config();
        String node = redisProperties.getRedisson().getAddress();
        String password = redisProperties.getRedisson().getPassword();
        int connectionMinimumIdleSize = redisProperties.getRedisson().getConnectionMinimumIdleSize();
        SingleServerConfig serverConfig = config.useSingleServer()
                .setAddress(node)
                .setTimeout(timeout)
                .setConnectionPoolSize(connectionPoolSize)
                .setConnectionMinimumIdleSize(connectionMinimumIdleSize);
        if(!StringUtils.isEmpty(password)){
            serverConfig.setPassword(password);
        }
        return Redisson.create(config);
    }





}
