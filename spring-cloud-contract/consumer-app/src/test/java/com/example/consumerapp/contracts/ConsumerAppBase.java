package com.example.consumerapp.contracts;

import com.example.consumerapp.config.IntegrationTest;
import com.example.consumerapp.controller.ConsumerAppController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@IntegrationTest
@AutoConfigureStubRunner(ids = {"io.github.diegolirio:usuario-imc:+:stubs:8081"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class ConsumerAppBase {

    @Autowired
    ConsumerAppController controller;

    @Before
    public void setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(controller);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }

    @Test
    public void test_controllerNotNull() {
        Assert.notNull(controller, "Nao pode ser null");
    }
}
