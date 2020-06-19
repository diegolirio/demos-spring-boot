package com.example.redisasdatabase.config.aws;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Base64;

@Profile("aws")
@Configuration
public class AWSSecretsManagerConfig {

    @Value("aws.secretManager.secretName")
    private String secretName;

    @Value("aws.secretManager.region")
    private String region;

    @Bean("awsSecretRedisAuth")
    public String getSecret() throws JsonProcessingException {
        AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard()
                                                                 .withRegion(region)
                                                                 .build();

        GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest().withSecretId(secretName);
        GetSecretValueResult getSecretValueResult = client.getSecretValue(getSecretValueRequest);

        String secret = getSecretValueResult.getSecretString();
        RedisAuth redisAuth = new ObjectMapper().readValue(secret, RedisAuth.class);
        return redisAuth.getRedisAuth();
    }
}