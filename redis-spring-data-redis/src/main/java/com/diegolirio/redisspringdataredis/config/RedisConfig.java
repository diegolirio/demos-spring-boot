package com.diegolirio.redisspringdataredis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    String host;
    @Value("${spring.redis.port}")
    int port;

// 1

//    List<String> clusterNodes = Arrays.asList(host + ":" + port);
//
//    @Bean
//    RedisConnectionFactory connectionFactory() {
//        return new JedisConnectionFactory(new RedisClusterConfiguration(clusterNodes));
//    }
//
//    @Bean
//    public JedisCluster getRedisCluster(){
//        Set<HostAndPort> jedisClusterNode = new HashSet<>();
//        jedisClusterNode.add(new HostAndPort(host, port));
//        JedisPoolConfig cfg = new JedisPoolConfig();
//        cfg.setMaxTotal(maxTotal);
//        cfg.setMaxIdle(maxIdle);
//        cfg.setMaxWaitMillis(10000);
//        cfg.setTestOnBorrow(true);
//        JedisCluster jc = new JedisCluster(jedisClusterNode, 10000, 1);
//        return jc;
//    }

//    @Bean
//    RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//        return new StringRedisTemplate(factory);
//    }

    // 2

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

    @Bean
    RedisConnectionFactory connectionFactory() {
        return new JedisConnectionFactory(new RedisClusterConfiguration(clusterNodes));
    }

    List<String> clusterNodes = Arrays.asList(
            "elasticacheredis-0001-001.opoms5.0001.use2.cache.amazonaws.com:6379",
            "elasticacheredis-0001-002.opoms5.0001.use2.cache.amazonaws.com:6379",
            "elasticacheredis-0001-003.opoms5.0001.use2.cache.amazonaws.com:6379",
            "elasticacheredis-0002-001.opoms5.0001.use2.cache.amazonaws.com:6379",
            "elasticacheredis-0002-002.opoms5.0001.use2.cache.amazonaws.com:6379",
            "elasticacheredis-0002-003.opoms5.0001.use2.cache.amazonaws.com:6379",
            "elasticacheredis-0003-001.opoms5.0001.use2.cache.amazonaws.com:6379",
            "elasticacheredis-0003-002.opoms5.0001.use2.cache.amazonaws.com:6379",
            "elasticacheredis-0003-003.opoms5.0001.use2.cache.amazonaws.com:6379"
    );

    @Bean
    RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        return new StringRedisTemplate(factory);
    }

}
