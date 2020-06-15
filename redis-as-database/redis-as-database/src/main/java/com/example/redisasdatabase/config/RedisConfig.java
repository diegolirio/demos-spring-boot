package com.example.redisasdatabase.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Configuration
public class RedisConfig {


    @Autowired
    private RedisCluster redisCluster;

    @Value("${enableCluster}")
    private boolean enableCluster;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    // @Bean
    // public JedisConnectionFactory redisConnectionFactory(final String host, final
    // int port) {
    // JedisConnectionFactory jedisConnectionFactory = new
    // JedisConnectionFactory(new RedisStandaloneConfiguration(host, port));
    // return jedisConnectionFactory;
    // }

    // @Bean
    // public RedisTemplate<?, ?> redisTemplate(@Value("${spring.redis.host}") final
    // String host,
    // @Value("${spring.redis.port}") final int port) {
    // final RedisTemplate<String, Object> template = new RedisTemplate<>();
    // template.setConnectionFactory(redisConnectionFactory(host, port));
    // return template;
    // }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory;
        if(enableCluster) {   
            log.info("enableCluster = {}", enableCluster);
            log.info("redis.cluster = {}", redisCluster.getNodes());
            RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(redisCluster.getNodes());            
            jedisConnectionFactory = new JedisConnectionFactory(redisClusterConfiguration);
        } else {   
            RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(host, port);
            redisStandaloneConfiguration.setDatabase(10);
            jedisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration);
        }
        return jedisConnectionFactory;
    }
    
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
        
}
