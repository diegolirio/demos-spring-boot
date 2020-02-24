package io.github.diegolirio.demospringboot2redis.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import redis.clients.jedis.Jedis;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableRedisRepositories
public class RedisConfiguration {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(this.host, this.port);
        return new JedisConnectionFactory(config);
    }

//    @Bean
//    public LettuceConnectionFactory redisConnectionFactory() {
//        LettuceConnectionFactory l = new LettuceConnectionFactory();
//        l.setHostName(host);
//        l.setPort(port);
//        return l;
//    }

    @Bean
    public RedisTemplate<?, ?> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());
        //template.expire("products", 10L, TimeUnit.SECONDS);
        return template;
    }

//    public static void main(String[] args) {
//        Jedis jedis = new Jedis("localhost");
//        jedis.set("usuario:19/12/1986:data-nascimento", "19/12/1986");
//
//        String s = jedis.get("usuario:19/12/1986:data-nascimento");
//        System.out.println(s);
//
//        Set<String> setKeys = findBirthdayByMouthAndYear(jedis, 12, 1986);
//        System.out.println(setKeys);
//
//    }
//
//    public static Set<String> findBirthdayByMouthAndYear(Jedis jedis, int mouth, int year) {
//        String key = "usuario:*/%02d/%04d:data-nascimento";
//        Set<String> keys = jedis.keys( String.format(key, mouth, year));
//        return keys;
//    }



}
