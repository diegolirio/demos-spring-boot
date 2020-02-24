package com.diegolirio.redisspringdataredis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

@Configuration
public class RedisConfig {

    @Bean
    public Jedis jedis(@Value("${spring.redis.host}") final String host,
                       @Value("${spring.redis.port}") final int port) {
        return new Jedis(host, port);
    }

    @Bean
    public JedisConnectionFactory redisConnectionFactory(final String host, final int port) {
        return new JedisConnectionFactory(new RedisStandaloneConfiguration(host, port));
    }

    @Bean
    public RedisTemplate<?, ?> redisTemplate(@Value("${spring.redis.host}") final String host,
                                             @Value("${spring.redis.port}") final int port) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory(host, port));
        return template;
    }

}
