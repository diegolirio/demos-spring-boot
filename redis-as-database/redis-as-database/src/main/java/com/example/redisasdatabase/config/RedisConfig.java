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

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory;
        if(enableCluster) {   
            log.info("enableCluster = {}", enableCluster);
            log.info("redis.cluster = {}", redisCluster.getNodes());
            RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(redisCluster.getNodes());            
            jedisConnectionFactory = new JedisConnectionFactory(redisClusterConfiguration);
        } else {   
            log.info("Host => {}:{}", host, port);
            RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(host, port);
            redisStandaloneConfiguration.setDatabase(10);
            redisStandaloneConfiguration.setPassword("d72f3d09-a29c-4996-8419-486c5d4528d5");
            jedisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration);
            jedisConnectionFactory.setUseSsl(true);
        }
        return jedisConnectionFactory;
    }
    
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

    // @Bean
    // public Jedis jedis() {
    //     Jedis jedis = new Jedis(this.host, this.port, true);
    //     jedis.connect();
    //     //jedis.auth("secret");

    //     //System.out.println(jedis.ping());
    //     return jedis;
    // }
        
}
