package com.example.demoneo4j.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories

@Configuration
@ComponentScan("com.example.demoneo4j")
@EnableNeo4jRepositories(basePackages = ["com.example.demoneo4j.repository"])
public class EnableNeo4jRepositories {

}