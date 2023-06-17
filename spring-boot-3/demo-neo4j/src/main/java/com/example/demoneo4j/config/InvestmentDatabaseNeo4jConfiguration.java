package com.example.demoneo4j.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.neo4j.ogm.config.Configuration.Builder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@ComponentScan(basePackages = { "com.example.demoneo4j.service" })
@Configuration
@EnableNeo4jRepositories(basePackages = "com.example.demoneo4j.repository")
public class InvestmentDatabaseNeo4jConfiguration {

    public static final String URL = System.getenv("NEO4J_URL") != null ? System.getenv("NEO4J_URL") : "http://neo4j:investments@localhost:7474";

    @Bean
    public org.neo4j.ogm.config.Configuration getConfiguration() {
        return new Builder().uri(URL).build();
    }

    @Bean
    public SessionFactory getSessionFactory() {
        return new SessionFactory(getConfiguration(), "com.example.demoneo4j.domain");
    }

//    @Bean
//    public Neo4jTransactionManager transactionManager() {
//        return new Neo4jTransactionManager(getSessionFactory());
//    }

}
