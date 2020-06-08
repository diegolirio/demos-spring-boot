package com.example.redismscustomer.config;

@Configuration
public class RedisConfig {

    @Bean
    public Jedis jedis() {
        return new Jedis(host, port);
    }

    @Bean
    public JedisCluster jedisCluster() {
        return null;
    }

}
