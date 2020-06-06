package com.example.redisasdatabase.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.JedisCluster;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("redis.cluster")
public class RedisConfig {


    private List<String> nodes = new ArrayList<>();

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

        public void get() {
        }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory;
        if(enableCluster) {   
            RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(nodes);            
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
