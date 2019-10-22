package io.github.diegolirio.usuarioimc.contracts;

import io.github.diegolirio.usuarioimc.config.IntegrationTest;
import io.github.diegolirio.usuarioimc.usuario.controllers.UsuarioV1RestController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@IntegrationTest
public class UsuarioBase {

    @Autowired
    UsuarioV1RestController userRestController;

    @Before
    public void setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(userRestController);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }

    @Test
    public void test_controllerNotNull() {
        Assert.notNull(userRestController, "Nao pode ser null");
    }

}
