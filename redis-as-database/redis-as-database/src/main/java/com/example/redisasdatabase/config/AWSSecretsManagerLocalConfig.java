package com.example.redisasdatabase.config;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Base64;

@Profile("local")
@Configuration
public class AWSSecretsManagerLocalConfig {

    @Bean("awsSecretRedisAuth")
    public String getSecret() {
        return "";
    }
}