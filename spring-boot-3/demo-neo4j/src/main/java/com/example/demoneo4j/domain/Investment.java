package com.example.demoneo4j.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

//@JsonIdentityInfo(generator = JSOGGenerator.class)

@NodeEntity
public class Investment {

    @Id
    @GeneratedValue
    Long customerId;

    private String investorProfile;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getInvestorProfile() {
        return investorProfile;
    }

    public void setInvestorProfile(String investorProfile) {
        this.investorProfile = investorProfile;
    }
}
