package com.mybatis.plus.stream;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "spring.redis", ignoreUnknownFields = false)
@Component
@Data
public class RedisProperties {

    private int database;
    private String host;
    private int port;
    private String password;
    private Lettuce lettuce;

    private Redisson redisson;

    @Data
    public static class Redisson {
        private String address;
        private String password;
        private Integer connectionMinimumIdleSize;
//        private Integer connectionPoolSize;
    }

    @Data
    public static class Lettuce {
        private LettucePool pool;
    }

    @Data
    public static class LettucePool {

        private int maxActive;
        private int maxIdle;
        private int minIdle;
        private Long maxWait;
        private Long timeOut;
        private Long shutdownTimeOut;
    }


}
