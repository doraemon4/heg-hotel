package com.heg.hotel.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {
    private String host;

    private int port;

    private int timeout;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig poolConfig  = new JedisPoolConfig();
        poolConfig.setMaxTotal(50); // 连接池中最大的活动连接数
        poolConfig.setMaxIdle(50); // 连接池中最大的空闲连接数
        poolConfig.setMinIdle(1); // 连接池中最小的空闲连接数
        poolConfig.setMaxWaitMillis(2000); // 获取连接时的最大等待毫秒数
        poolConfig.setTestOnBorrow(true); // 在获取连接时是否进行验证

        JedisPool jedisPool = new JedisPool(poolConfig , host, port, timeout);
        return jedisPool;
    }
}