package com.example.redismscustomer.config;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisClusterConnection;

@Configuration
public class RedisConfig {

    @Bean
    public Jedis jedis() {
        return new Jedis();
    }
//
//    @Bean
//    public JedisClusterConnection jedisCluster() {
//        return null;
//    }

}
