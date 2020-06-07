package com.example.redisasdatabase.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Getter
@Configuration
@ConfigurationProperties("redis.cluster")
public class RedisCluster {

    private List<String> nodes = new ArrayList<>();

}