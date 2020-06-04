package com.diegolirio.redisspringdataredis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.List;

@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    String host;
    @Value("${spring.redis.port}")
    int port;

    List<String> clusterNodes = Arrays.asList(host + ":" + port);

    @Bean
    RedisConnectionFactory connectionFactory() {
        return new JedisConnectionFactory(new RedisClusterConfiguration(clusterNodes));
    }

    @Bean
    RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        return new StringRedisTemplate(factory);
    }

    @Bean
    public Jedis jedis() {
        return new Jedis(host, port);
    }


//    @Bean
//    public JedisConnectionFactory redisConnectionFactory(final String host, final int port) {
//        return new JedisConnectionFactory(new RedisStandaloneConfiguration(host, port));
//    }
//
//    @Bean
//    public RedisTemplate<?, ?> redisTemplate(@Value("${spring.redis.host}") final String host,
//                                             @Value("${spring.redis.port}") final int port) {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory(host, port));
//        return template;
//    }

}
