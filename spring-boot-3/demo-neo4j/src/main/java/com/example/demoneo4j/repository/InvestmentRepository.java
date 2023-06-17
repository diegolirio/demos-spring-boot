package com.example.demoneo4j.repository;

import com.example.demoneo4j.domain.Investment;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface InvestmentRepository extends Neo4jRepository<Investment, Long> {

//    Investment findByInvestorProfile(@Param("investorProfile") String investorProfile);

//    @Query("MATCH (i:Investment) WHERE i.investorProfile =~ ('(?i).*'+{investorProfile}+'.*') RETURN i")
//    Collection<Investment> findByInvestorProfileContaining(@Param("investorProfile") String investorProfile);

    // @Query("MATCH (i:Investment)<-[:ACTED_IN]-(a:Person) RETURN m.title as movie, collect(a.name) as cast LIMIT {limit}")
    // List<Map<String, Object>> graph(@Param("limit") int limit);

}
